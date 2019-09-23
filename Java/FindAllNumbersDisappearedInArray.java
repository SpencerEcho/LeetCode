import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
// Find all the elements of [1, n] inclusive that do not appear in this array.
// Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

// Example:
// Input:
// [4,3,2,7,8,2,3,1]
// Output:
// [5,6]
public class FindAllNumbersDisappearedInArray {
	public static void main(String[] args) {
		FindAllNumbersDisappearedInArray solution = new FindAllNumbersDisappearedInArray();
		int[] arr = {4,3,2,7,8,2,3,1};
		System.out.println(Arrays.toString(solution.findDisappearedNumbers_1(arr).toArray()));
	}

	/**
	 * 第一步，由于元素是从1开始都的，因此原数组中的元素存入新数组中，对应的索引为元素值-1
	 * 第二部，从新数组中找出所有不符合索引值+1等于元素值的元素
	 * 
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers_1(int[] nums) {
		int[] arr = new int[nums.length];
		for (int n : nums) {
			arr[n-1] = n;
		}
		List<Integer> list = new ArrayList<>();
		for (int i=0; i< arr.length; i++) {
			if (arr[i] != i+1) {
				list.add(i+1);
			}
		}
		return list;
    }
}