// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
// You may assume no duplicates in the array.

// Example 1:

// Input: [1,3,5,6], 5
// Output: 2
// Example 2:

// Input: [1,3,5,6], 2
// Output: 1
// Example 3:

// Input: [1,3,5,6], 7
// Output: 4
// Example 4:

// Input: [1,3,5,6], 0
// Output: 0

/**
 * 典型的有序查找
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();

        int[] nums_1 = {1,3,5,6};
        int target_1 = 5;
        System.out.println(solution.searchInsert_1(nums_1, target_1));
        System.out.println(solution.searchInsert_2(nums_1, target_1));

        int[] nums_2 = {1,3,5,6};
        int target_2 = 2;
        System.out.println(solution.searchInsert_1(nums_2, target_2));
        System.out.println(solution.searchInsert_2(nums_2, target_2));

        int[] nums_3 = {1,3,5,6};
        int target_3 = 7;
        System.out.println(solution.searchInsert_1(nums_3, target_3));
        System.out.println(solution.searchInsert_2(nums_3, target_3));


        int[] nums_4 = {1,3,5,6};
        int target_4 = 0;
        System.out.println(solution.searchInsert_1(nums_4, target_4));
        System.out.println(solution.searchInsert_2(nums_4, target_4));
    }

    /**
     * 普通查找
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert_1(int[] nums, int target) {
        int i = 0;
        while (i < nums.length && nums[i] < target) {
            i++;
        }
        return i;
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert_2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if(target > nums[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}