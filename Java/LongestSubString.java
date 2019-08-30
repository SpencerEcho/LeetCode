import java.util.HashMap;
import java.util.Map;

// Given a string, find the length of the longest substring without repeating characters.

// Example 1:
// Input: "abcabcbb"
// Output: 3 
// Explanation: The answer is "abc", with the length of 3. 

// Example 2:
// Input: "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// Example 3:
// Input: "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3. 
//              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


/**
 * Tag： 字符串 匹配
 * 解法：滑动窗口
 */
public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring solution = new LongestSubstring();
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = " ";

        System.out.println(solution.lengthOfLongestSubstring_5(s1));
        System.out.println(solution.lengthOfLongestSubstring_5(s2));
        System.out.println(solution.lengthOfLongestSubstring_5(s3));
        System.out.println(solution.lengthOfLongestSubstring_5(s4));
    }

    /**
     * 暴力解法
     * 本方法采用失配后，原字符串中指针i回溯的方式，即当前位置失配后，原字符串中的指针回溯到开始位置的下一位继续匹配
     * 该实现看似单层循环，但是时间复杂度并不是n，因为指针i会不断回溯
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_1(String s) {
        String sub = "";
        int maxLength = 0;
        for (int i=0; i<s.length(); i++) {
            //如果子串中含有目标字符，失配
            if (sub.indexOf(s.charAt(i)) > -1) {
                maxLength = Math.max(sub.length(), maxLength);
                //指针回溯到开始位置的上一位，这里本应该是i-sub.length()-1，但是i在循环结束的时候要i++
                i = i - sub.length();
                sub = "";
            } else {
                sub += s.charAt(i);
            }
        }
        //这里没有直接用maxLength，是因为s.length()-1有可能不会失配
        return Math.max(sub.length(), maxLength);
    }

    /**
     * 本方法采用失配后，子串回溯的方式，原始字符串指针不变
     *
     *  缺点：1. substring操作，需要new string，且底层是数组拷贝
     *       2. indexOf操作，底层是循环遍历，起始位置默认为第一个字符
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_2(String s) {
        String sub = "";
        int maxLength = 0;
        for (int i=0; i<s.length();i++) {
            //如果子串中还有目标字符，失配
            if (sub.indexOf(s.charAt(i)) > -1) {
                maxLength = Math.max(sub.length(), maxLength);
                //子串从失配的下一位处截断
                sub = sub.substring(sub.indexOf(s.charAt(i))+1);
            }
            //将失配位置字符放入子串，如果这里不加回去，会造成位置遗漏的情况
            sub += s.charAt(i);
        }
        return Math.max(sub.length(), maxLength);
    }

    /**
     * 解法2的升级，循环中不需要new一个子串，只是变换原数组的下表，节省new string的时间
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_3(String s) {
        int maxLength = 0;
        int l=0;
        //这里r指针用初始值为-1，是为了防止“”这种字符串的case。
        int r=-1;
        int indexOfC = -1;
        for (int i=0; i<s.length(); i++) {
            //从l位置开始遍历，直到找到第一个目标字符
            indexOfC = s.indexOf(s.charAt(i),l);
            //如果目标字符的位置小于等于r，失配
            if ( indexOfC <= r) {
                //最大长度为左右指针的间距，或原最大长度
                maxLength = Math.max(r-l+1, maxLength);
                //适配后，左指针移动到适配位置的下一位
                l = indexOfC + 1;
            }
            //有指针后移一位
            r++;
        }
        return Math.max(r-l+1, maxLength);
    }

    /**
     * hashmap解法，但效率没有解法3高
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_4(String s) {
        int maxLength = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r=0; r<s.length(); r++) {
            //如果map中存在目标字符，失配
            if (map.containsKey(s.charAt(r))) {
                //失配后，l调整到map的value位置
                //这里用max而不是直接用map.get()，是防止失配的时候l指针回退，比如abba的匹配过程
                l = Math.max(map.get(s.charAt(r)),l);
            }
            //重新计算最大长度
            maxLength = Math.max(maxLength, r-l+1);
            //将目标字符串放入map，value为失配后，l指向的位置
            map.put(s.charAt(r), r+1);
        }
        return maxLength;
    }


    /**
     * ascii码解法，效率稍高于解法3
     * 类似与解法4，将map换成数组
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_5(String s) {
        int maxLength = 0;
        int[] arr = new int[128];
        int l = 0;
        for (int r=0; r<s.length(); r++) {
            //这里用max而不是直接用arr[s.charAt(r)]，是防止失配的时候l指针回退，比如abba的匹配过程
            l = Math.max(arr[s.charAt(r)],l);
            maxLength = Math.max(maxLength, r-l+1);
            //将r的下一个位置放入字符的ascii位置
            //这里的r+1是失配后，l指针应该指向的位置
            arr[s.charAt(r)] = r+1;
        }
        return maxLength;
    }
}