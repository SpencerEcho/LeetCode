import java.util.HashMap;

// Given an array of integers and an integer k, find out whether there are two distinct indices i and j 
// in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

// Example 1:
// Input: nums = [1,2,3,1], k = 3
// Output: true

// Example 2:
// Input: nums = [1,0,1,1], k = 1
// Output: true

// Example 3:
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false

public class ContainsDuplicateII {
	public static void main(String[] args) {
		ContainsDuplicateII solution = new ContainsDuplicateII();
		int[] arr_1 = {1,2,3,1}, arr_2={1,0,1,1}, arr_3={1,2,3,1,2,3};
		int k_1 = 3, k_2 = 1, k_3 = 2;
		System.out.println(solution.containsNearbyDuplicate(arr_1, k_1));
		System.out.println(solution.containsNearbyDuplicate(arr_2, k_2));
		System.out.println(solution.containsNearbyDuplicate(arr_3, k_3));
	}

	/**
	 * hashmap法
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
				return true;
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
    }
}