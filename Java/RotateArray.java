import java.util.Arrays;

// Given an array, rotate the array to the right by k steps, where k is non-negative.

// Example 1:
// Input: [1,2,3,4,5,6,7] and k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]

// Example 2:
// Input: [-1,-100,3,99] and k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]

// Note:
// Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
// Could you do it in-place with O(1) extra space?

public class  RotateArray {
	public static void main(String[] args) {
		 RotateArray solution = new  RotateArray();
		 int[] arr1_1 = {1,2,3,4,5,6,7};
		 int k1_1 = 3;
		 solution.rotate_1(arr1_1, k1_1);
		 System.out.println(Arrays.toString(arr1_1));

		 int[] arr2_1 = {-1,-100};
		 int k2_1 = 3;
		 solution.rotate_1(arr2_1, k2_1);
		 System.out.println(Arrays.toString(arr2_1));

		 int[] arr1_2 = {1,2,3,4,5,6,7};
		 int k1_2 = 3;
		 solution.rotate_2(arr1_2, k1_2);
		 System.out.println(Arrays.toString(arr1_2));
		 
		 int[] arr2_2 = {-1,-100};
		 int k2_2 = 3;
		 solution.rotate_2(arr2_2, k2_2);
		 System.out.println(Arrays.toString(arr2_2));

		 int[] arr1_3 = {1,2,3,4,5,6,7};
		 int k1_3 = 3;
		 solution.rotate_3(arr1_3, k1_3);
		 System.out.println(Arrays.toString(arr1_3));
		 
		 int[] arr2_3 = {-1,-100};
		 int k2_3 = 3;
		 solution.rotate_3(arr2_3, k2_3);
		 System.out.println(Arrays.toString(arr2_3));
	}

	/**
	 * 以空间换时间方法，需要N-K个空间，时间复杂度为3，
	 * 题目翻译后，rotate k次就是将从后往前数的k个元素，移动到数组前面。这里注意k大于数组长度的情况
	 * @param nums
	 * @param k
	 */
	public void rotate_1(int[] nums, int k) {
		//如果k大于nums.length，需要取余，因为rotate n倍的nums.length次，实际上是原地不动
		k = k % nums.length;
		int[] leftArr = new int[nums.length-k];
		//左边nums.length-k个元素先暂存入leftArr
		System.arraycopy(nums, 0, leftArr, 0, nums.length-k);
		//右侧k个元素拷贝到左侧
		System.arraycopy(nums, nums.length-k, nums, 0, k);
		//leftArr中的元素放入nums右侧
		System.arraycopy(leftArr, 0, nums, k, nums.length-k);
	}
	
	/**
	 * 时间换空间方法，时间复杂度O(k)，空间复杂度O(1)
	 * 根据rotate的过程，每一步rotate，就是将最后一个元素移动到0位置
	 * @param nums
	 * @param k
	 */
	public void rotate_2(int[] nums, int k) {
		//如果k大于nums.length，需要取余，因为rotate n倍的nums.length次，实际上是原地不动
		k = k % nums.length;
		int temp;
		for (int i=0; i<k; i++) {
			temp = nums[nums.length-1];
			System.arraycopy(nums, 0, nums, 1, nums.length-1);
			nums[0] = temp;
		}
	}

	/**
	 * 翻转法，基于以下事实：数组rotate k次后，k%n个元素会被移动到数组前面，剩余元素后移
	 * 在这个方法中，首先将所有元素反转，然后前面k个元素反转，再将后面n-k个元素反转，就得到想要的结果
	 * 过程：
	 * 初始态：    1 2 3 4 5 6 7
	 * 第一步反转： 7 6 5 4 3 2 1
	 * 第二步反转： 5 6 7 4 3 2 1
	 * 第三步反转： 5 6 7 1 2 3 4
	 * @param nums
	 * @param k
	 */
	public void rotate_3(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
	}

	//双指针，反转元素
	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
	}
}