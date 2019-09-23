import java.util.Arrays;
import java.util.HashMap;

// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Example:
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]

// Note:
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

public class MoveZeros {
	public static void main(String[] args) {
		MoveZeros solution = new MoveZeros();
		int[] arr_1 = {0,1,0,3,12};
		solution.moveZeroes_1(arr_1);
		System.out.println(Arrays.toString(arr_1));

		int[] arr_2 = {0,1,0,3,12};
		solution.moveZeroes_2(arr_2);
		System.out.println(Arrays.toString(arr_2));

		int[] arr_3 = {0,1,0,3,12};
		solution.moveZeroes_3(arr_3);
		System.out.println(Arrays.toString(arr_3));

		int[] arr_4 = {0,1,0,3,12};
		solution.moveZeroes_4(arr_4);
		System.out.println(Arrays.toString(arr_4));

	}

	/**
	 * 暴力法：遇到0，后面的数就向前移动
	 * 非0元素重复移动多次
	 * @param nums
	 */
	public void moveZeroes_1(int[] nums) {
		int i = 0, j = nums.length;
		while (i<j) {
			if (nums[i] == 0) {
				for (int k=i+1; k<j; k++) {
					nums[k-1] = nums[k];
				}
				j--;
				nums[j] = 0;
			} else {
				i++;
			}
		}
	}
	
	/**
	 * hashmap法，将元素放入hasnmap，再将非0元素按原先顺序取出来，最后在剩余位置填入0
	 * @param nums
	 */
	public void moveZeroes_2(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = 0;
		while (i < nums.length) {
			map.put(i, nums[i]);
			i++;
		}
		i = 0;
		for (Integer k : map.keySet()) {
			if (map.get(k) != 0) {
				nums[i++] = map.get(k);
			}	
		}
		while (i < nums.length) {
			nums[i++] = 0;
		}
	}

	/**
	 * 快、慢指针
	 * 非0元素按原先顺序填入数组中，剩余位置补0
	 * 如果有0个数多，会执行多次执行写入0操作。
	 * @param nums
	 */
	public void moveZeroes_3(int[] nums) {
		int slow_p = 0, fast_p = 0;
		while (fast_p < nums.length) {
			if (nums[fast_p] != 0) {
				nums[slow_p++] = nums[fast_p];
			}
			fast_p++;
		}
		while (slow_p < nums.length) {
			nums[slow_p++] = 0;
		}
	}

	/**
	 * 快、慢指针（最优解）：写入次数最少
	 * 慢指针前面的元素一定是非0元素，开指针与慢指针之间的数一定是0元素
	 * 遇到非0元素，交换快、慢指针元素，然后两个指针都后移，否则只后移快指针
	 * @param nums
	 */
	public void moveZeroes_4(int[] nums) {
		int temp = 0;
		for (int slow_p=0, fast_p=0; fast_p < nums.length; fast_p++) {
			if (nums[fast_p] != 0) {
				//交换非0元素与0元素
				temp = nums[fast_p];
				nums[fast_p] = nums[slow_p];
				nums[slow_p] = temp;
				//慢指针后移
				slow_p++;
			}
		}
	}
}