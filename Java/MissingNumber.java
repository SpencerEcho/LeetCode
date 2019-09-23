import java.util.Arrays;

// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
// find the one that is missing from the array.

// Example 1:
// Input: [3,0,1]
// Output: 2

// Example 2:
// Input: [9,6,4,2,3,5,7,0,1]
// Output: 8

// Note:
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

public class MissingNumber {
	public static void main(String[] args) {
		MissingNumber solution = new MissingNumber();
		int[] arr_1 = {1,2}, arr_2 = {9,6,4,2,3,5,7,0,1}, arr_3 = {9};
		System.out.println(solution.missingNumber_1(arr_1));
		System.out.println(solution.missingNumber_1(arr_2));
		System.out.println(solution.missingNumber_1(arr_3));

		// System.out.println(solution.missingNumber_2(arr_1));
		// System.out.println(solution.missingNumber_2(arr_2));
		// System.out.println(solution.missingNumber_2(arr_3));
	}


	/**
	 * 数学法
	 * 注意审题：n个元素，最大的数为n
	 * @param nums
	 * @return
	 */
	public int missingNumber_1(int[] nums) {
		int exp= (1+nums.length)*nums.length/2;
		int sum = 0;
		for (int n : nums) {
			sum += n;	
		}
		return sum - exp;
	}

	/**
	 * 排序法：先排序，再找不连续的元素
	 * @param nums
	 * @return
	 */
	public int missingNumber_2(int[] nums) {
		Arrays.sort(nums);
		//判断n是否处于末位
		if (nums[nums.length-1] != nums.length) {
			return nums.length;
			//判断0是否处于首位
		} else if (nums[0] != 0) {
			return 0;
		}
		//此时，缺失的数在0...n之间
		for (int i=0; i <nums.length-1; i++) {
			if (nums[i+1]-nums[i] != 1) {
				return nums[i]+1;
			}
		}
		return -1;
    }
}