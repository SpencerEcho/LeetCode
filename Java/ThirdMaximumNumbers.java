// Given a non-empty array of integers, return the third maximum number in this array. 
// If it does not exist, return the maximum number. The time complexity must be in O(n).

// Example 1:
// Input: [3, 2, 1]
// Output: 1
// Explanation: The third maximum is 1.

// Example 2:
// Input: [1, 2]
// Output: 2
// Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

// Example 3:
// Input: [2, 2, 3, 1]
// Output: 1
// Explanation: Note that the third maximum here means the third maximum distinct number.
// Both numbers with value 2 are both considered as second maximum.

public class ThirdMaximumNumbers {
	public static void main(String[] args) {
		ThirdMaximumNumbers solution = new ThirdMaximumNumbers();
		int[] arr_1 = {1, 2, 2,5,3,5};
		int[] arr_2 = {1, 2};
		int[] arr_3 = {1,-2147483648,2};
		System.out.println(solution.thirdMax(arr_1));
		System.out.println(solution.thirdMax(arr_2));
		System.out.println(solution.thirdMax(arr_3));
	}

	/**
	 * 三指针法，遍历数组找出前三个最大数
	 * 注意：这里初始值不能用Integer.MIN_VALUE，因为数组中如果存在这个元素时，最终不好判断
	 * @param nums
	 * @return
	 */
	public int thirdMax(int[] nums) {
		long firstMax = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;
        for (int n : nums) {
			//如果存在重复元素，跳过
			if (n == firstMax || n == secondMax || n == thirdMax) {
				continue;
			}
			if (n > firstMax) {
				//如果secondMax是初始值，跳过，避免进行无意义写值操作
				if (secondMax != Long.MIN_VALUE) {
					thirdMax = secondMax;
				}
				if (firstMax != Long.MIN_VALUE) {
					secondMax = firstMax;
				}
				firstMax = n;
			} else if (n > secondMax) {
				if (secondMax != Long.MIN_VALUE) {
					thirdMax = secondMax;
				}
				secondMax = n;
			} else if (n >= thirdMax) {
				thirdMax = n;
			}
		}
		return thirdMax == Long.MIN_VALUE ? (int)firstMax : (int)thirdMax;
    }
}