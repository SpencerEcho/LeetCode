import java.util.HashMap;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 */
public class MajorityElement {
	public static void main(String[] args) {
		MajorityElement solution = new MajorityElement();
		int[] arr_1 = {3,2,3};
		int[] arr_2 = {2,2,1,1,1,2,2};
		System.out.println(solution.majorityElement_1(arr_1));
		System.out.println(solution.majorityElement_1(arr_2));

		System.out.println(solution.majorityElement_2(arr_1));
		System.out.println(solution.majorityElement_2(arr_2));		
	}
	
	/**
	 * hashmap方法，时间复杂度O(N)
	 * @param nums
	 * @return
	 */
	public int majorityElement_1(int[] nums) {
		int majorityEle = nums[0];
		int max = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			int numCount = map.get(num) == null ? 1 : map.get(num)+1;
			map.put(num, numCount);
			if (map.get(num) > max) {
				max = map.get(num);
				majorityEle = num;
			}
		}
		return majorityEle;
	}
	
	/**
	 * Boyer-Moore 投票算法(投票算法只适用于众数出现次数>=n/2。因为前半段出现n/2-1正好在倒数第一个数，计数器被清零了，返回的众数是最后一个数。)
	 * 想法:
	 * 如果我们把众数记为 +1+1 ，把其他数记为 -1−1 ，将它们全部加起来，显然和大于 0 ，从结果本身我们可以看出众数比其他数多。
	 * 
	 * 算法:
	 * 本质上， Boyer-Moore 算法就是找 nums 的一个后缀 sufsuf ，其中 suf[0]suf[0] 就是后缀中的众数。我们维护一个计数器，
	 * 如果遇到一个我们目前的候选众数，就将计数器加一，否则减一。只要计数器等于 0 ，我们就将 nums 中之前访问的数字全部 忘记 ，
	 * 并把下一个数字当做候选的众数。
	 * 
	 * 算法推演：
	 * 直观上这个算法不是特别明显为何是对的，我们先看下面这个例子（竖线用来划分每次计数器归零的情况）
	 * [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
	 * 首先，下标为 0 的 7 被当做众数的第一个候选。在下标为 5 处，计数器会变回0 。所以下标为 6 的 5 是下一个众数的候选者。由于这个例子中 7 是
	 * 真正的众数，所以通过忽略掉前面的数字，我们忽略掉了同样多数目的众数和非众数。因此， 7 仍然是剩下数字中的众数。
	 * [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 5, 5, 5, 5]
	 * 现在，众数是 5 （在计数器归零的时候我们把候选从 7 变成了 5）。此时，我们的候选者并不是真正的众数，但是我们在 遗忘 前面的数字的时候，要去掉相同
	 * 数目的众数和非众数（如果遗忘更多的非众数，会导致计数器变成负数）。
	 * 因此，上面的过程说明了我们可以放心地遗忘前面的数字，并继续求解剩下数字中的众数。最后，总有一个后缀满足计数器是大于 0 的，此时这个后缀的众数就是整个数组的众数。
	 */
	public int majorityElement_2(int[] nums) {
		int major = nums[0];
		int count = 0;
		for (int num : nums) {
			if (count == 0) {
				major = num;
			}
			count += major==num ? 1 : -1;
		}
		return major;
	}
}