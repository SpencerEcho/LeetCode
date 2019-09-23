// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// Example:

// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.

public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray solution = new MaxSubArray();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray_1(nums));
        System.out.println(solution.maxSubArray_2(nums));
    }

    /**
     * 暴力解法：枚举出所有的序列及和，找出其中最大的一个
     * @param nums
     * @return
     */
    public int maxSubArray_1(int[] nums) {
        int maxEndingHere = 0;
        int maxSoFar = 0;

        for (int i=0; i<nums.length; i++) {
            //每层循环开始，清0
            maxEndingHere = 0;
            for (int j=i; j <nums.length; j++) {
                //从位置i开始到当前位置的和
                maxEndingHere += nums[j];
                //从0开始到当前位置的最大值
                maxSoFar = Math.max(maxEndingHere, maxSoFar);
            }
        }
        return maxSoFar;
    }

    /**
     * 动态规划解法：maxSoFar存储最大值，maxEndingHere只管往后加，变成负数就不继续加了，转而指向下一个数，然后重复同样的步骤往后加。
     * 
     * maxEndingHere大于0，说明对最终结果正向作用，保留
     * maxEndingHere小于0，说明对最终结果负向作用，从当前值开始重新计算
     * 每次循环比较maxEndingHere和maxSoFar，保留当中的最大者
     * @param nums
     * @return
     */
    public int maxSubArray_2(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = 0;
        for (int num : nums) {
            if (maxEndingHere > 0) {
                maxEndingHere += num;
            } else {
                maxEndingHere = num;
            }
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }

}