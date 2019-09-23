import java.util.Arrays;

// Given an array nums and a value val, remove all instances of that value in-place and return the new length.
// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

// Example 1:
// Given nums = [3,2,2,3], val = 3,
// Your function should return length = 2, with the first two elements of nums being 2.
// It doesn't matter what you leave beyond the returned length.

// Example 2:
// Given nums = [0,1,2,2,3,0,4,2], val = 2,
// Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
// Note that the order of those five elements can be arbitrary.
// It doesn't matter what values are set beyond the returned length.

// Clarification:
// Confused why the returned value is an integer but your answer is an array?
// Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
// Internally you can think of this:
// // nums is passed in by reference. (i.e., without making a copy)
// int len = removeElement(nums, val);
// // any modification to nums in your function would be known by the caller.
// // using the length returned by your function, it prints the first len elements.
// for (int i = 0; i < len; i++) {
//     print(nums[i]);
// }

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
        int[] nums_1 = {3,2,2,3};
        int val_1 = 3;
        System.out.println(solution.removeElement_2(nums_1, val_1));
        System.out.println(Arrays.toString(nums_1));

        int[] nums_2 = {0,1,2,2,3,0,4,2};
        int val_2 = 2;
        System.out.println(solution.removeElement_2(nums_2, val_2));
        System.out.println(Arrays.toString(nums_2));
    }

    /**
     * 双指针
     * 初始，两个指针均从下标0开始
     * 
     * nums[i]与val不等时，复制nums[i]到nums[t]，递增i、t；否则，递增i，跳过该元素
     *
     * 缺点：如果数组中与val相同的数少，那么大部分操作都浪费在原地赋值上
     * @param nums
     * @param val
     * @return
     */
    public int removeElement_1(int[] nums, int val) {
        int t = 0, i = 0;
        //下标均从0开始
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[t] = nums[i];
                t++;
                i++;
            } else {
                i++;
            }
        }
        //这里返回t，注意观察上面的循环，t其实就是数组中与val不同的值的计数
        return t;
    }

    /**
     * 双指针，适用于原数组中与val相同的数少的case，否则，无意义的元素交换占据大部分操作
     * 
     * 初始，两个指针，分别指向第一个元素和最后一个元素
     * 当前值与val相等时，将当前值与最后一个元素交换，且后面的指针前移，释放最后一个元素；否则，前面的指针后移
     * 
     * 这个方法，通过交换，后指针前移，达到将原数组中与val相同的元素剔除的目的，构造出的新数组（0-n之间），只包含与val不同的元素。
     * 
     * 
     * @param nums
     * @param val
     * @return
     */
    public int removeElement_2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            //注意这里交换后，i没有递增，下次循环的时候，nums[i]的新值会再判断一次
            if (nums[i] == val) {
                nums[i] = nums[n-1];
                n--;
            } else {
                i++;
            }
        }
        //与原数组长度相比，n减去的部分，即为数组中与val相等的元素个数
        return n;
    }
}