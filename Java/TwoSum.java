import java.util.Arrays;
import java.util.HashMap;

// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
// Example:

// Given nums = [2, 7, 11, 15], target = 9,
// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].

/** 
 * 类型：数组
 * 解法提示：循环、hashmap
 * 
 * 注意：用hashmap时，要边存边查，而不能一股脑的将数字全部存入hashmap，因为会造成后面的数覆盖前面的（数组出现两个相同数时会出错）
*/
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2,3,4};
        int target = 6;
        System.out.println(Arrays.toString( twoSum.twoSum_1(nums, target)));
        System.out.println(Arrays.toString( twoSum.twoSum_2(nums, target)));        
    }

    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_1(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j< nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 利用hashmap快速查找的特性，可以省掉一层循环
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}