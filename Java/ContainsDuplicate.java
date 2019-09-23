import java.util.Arrays;
import java.util.HashSet;

// Given an array of integers, find if the array contains any duplicates.
// Your function should return true if any value appears at least twice in the array,
// and it should return false if every element is distinct.

// Example 1:
// Input: [1,2,3,1]
// Output: true

// Example 2:
// Input: [1,2,3,4]
// Output: false

// Example 3:
// Input: [1,1,1,3,3,4,3,2,4,2]
// Output: true

public class ContainsDuplicate {
	public static void main(String[] args) {
		ContainsDuplicate solution = new ContainsDuplicate();
		int[] arr_1 = {1,2,3,1};
		int[] arr_2 = {1,2,3,4};
		int[] arr_3 = {1,1,1,3,3,4,3,2,4,2};
		System.out.println(solution.containsDuplicate_1(arr_1));
		System.out.println(solution.containsDuplicate_1(arr_2));
		System.out.println(solution.containsDuplicate_1(arr_3));

		System.out.println(solution.containsDuplicate_2(arr_1));
		System.out.println(solution.containsDuplicate_2(arr_2));
		System.out.println(solution.containsDuplicate_2(arr_3));

	}


	/**
	 * hash表方法
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate_1(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int n : nums) {
			if (set.contains(n)) {
				return true;
			} else {
				set.add(n);
			}
		}
		return false;
	}
	
	/**
	 * 排序法：先排序，再查找相邻元素是否相同
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate_2(int[] nums) {
		Arrays.sort(nums);
		for (int i=0; i<nums.length-1; i++) {
			if (nums[i] == nums[i+1]) {
				return true;
			}
		}
		return false;
	}
	
}