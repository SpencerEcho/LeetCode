import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

// Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

// Example 1:
// Given nums = [1,1,2],

// Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
// It doesn't matter what you leave beyond the returned length.

// Example 2:
// Given nums = [0,0,1,1,1,2,2,3,3,4],

// Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
// It doesn't matter what values are set beyond the returned length.

// Clarification:

// Confused why the returned value is an integer but your answer is an array?
// Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

// Internally you can think of this:
// // nums is passed in by reference. (i.e., without making a copy)
// int len = removeDuplicates(nums);

// // any modification to nums in your function would be known by the caller.
// // using the length returned by your function, it prints the first len elements.
// for (int i = 0; i < len; i++) {
//     print(nums[i]);
// }

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums_1 = {-3,-1,0,0,0,3,3};
        int[] nums_2 = {0,0,1,1,1,2,2,3,3,4};

        RemoveDuplicates solution = new RemoveDuplicates();
        System.out.println("length: " + solution.removeDuplicates_2(nums_1));
        System.out.println("nums: " + Arrays.toString(nums_1));

        System.out.println("length: " + solution.removeDuplicates_2(nums_2));
        System.out.println("nums: " + Arrays.toString(nums_2));

    }

    /**
     * 其实不应该用这样的方法，因为题目要求原地操作，且空间复杂度为O(1)。
     * map存放方法，不能用hashmap，因为hashmap是无序的，最终出来的顺序可能与存放顺序不一致，比如{-3,-1,0,0,0,3,3}
     * 缺点：
     *      时间：两个循环，耗时
     *      空间：开辟map空间，消耗内存
     */
    public int removeDuplicates_1(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        int i=0;
        for (i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        i = 0;
        for (int n : map.keySet()) {
            nums[i] = n;
            i++;
        }
        return map.size();
    }

    /**
     * 设置快、慢两个指针，如果快、慢指针的值一致，快指针继续往后走，否则慢指针后移，且快指针的值赋给慢指针
     * 
     * 注意：快指针要从1开始
     * 
     */
    public int removeDuplicates_2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //慢指针
        int t = 0;
        //快指针从1开始
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[t]) {
                t++;
                nums[t] = nums[i];
            }
        }
        //最终值为t+1，因为索引从0开始
        return t+1;
    }
}