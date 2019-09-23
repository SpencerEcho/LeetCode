import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Note:
 * our returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumII {
	public static void main(String[] args) {
		TwoSumII solution = new TwoSumII();
		int[] nums = {2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(solution.twoSum_1(nums, target)));
		System.out.println(Arrays.toString(solution.twoSum_2(nums, target)));		
	}

	/**
	 * hashmap判断差值法，但没有用到数组已经有序的性质
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum_1(int[] numbers, int target) {
		int[] arr = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<numbers.length; i++) {
			int diff = target - numbers[i];
			if (!map.containsKey(diff)) {
				map.put(numbers[i], i);
			} else {
				arr[0] = map.get(diff)+1;
				arr[1] = i+1;
				break;
			}
		}
		return arr;
	}
	
	/**
	 * 双指针法
	 * 两个指针，分别从头、尾向中间移动，查找low+high和等于target
	 */
	public int[] twoSum_2(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int sum = nums[low] + nums[high];
			if (sum == target) {
				return new int[]{low+1, high+1};
			} else if (sum > target) {
				high--;
			} else {
				low++;
			}
		}
		return new int[]{-1, -1};
	}
}