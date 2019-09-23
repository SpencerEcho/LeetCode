import java.util.Arrays;

// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
// Note:
// The number of elements initialized in nums1 and nums2 are m and n respectively.
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

// Example:
// Input:
// nums1 = [1,2,3,0,0,0], m = 3
// nums2 = [2,5,6],       n = 3

// Output: [1,2,2,3,5,6]

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();

        int[] nums1_1 = {1,2,3,0,0,0};
        int m_1 = 3;
        int[] nums2_1 = {2,5,6};
        int n_1 = 3;

        int[] nums1_2 = {4,5,6,0,0,0};
        int m_2 = 3;
        int[] nums2_2 = {1,2,3};
        int n_2 = 3;

        // solution.merge_1(nums1_1, m_1, nums2_1, n_1);
        // solution.merge_1(nums1_2, m_2, nums2_2, n_2);
        // System.out.println(Arrays.toString(nums1_1));
        // System.out.println(Arrays.toString(nums1_2));

        solution.merge_2(nums1_1, m_1, nums2_1, n_1);
        solution.merge_2(nums1_2, m_2, nums2_2, n_2);
        System.out.println(Arrays.toString(nums1_1));
        System.out.println(Arrays.toString(nums1_2));

    }

    /**
     * 合并到新数组后，再填回原数组
     * 缺点：需要额外空间O（m+n）
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m+n];
        int i=0, j=0, k=0;
        while (i<m || j<n) {
            if (i>=m) {
                arr[k] = nums2[j];
                j++;
            } else if (j >= n) {
                arr[k] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i++;
            } else {
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        for (int t=0; t<arr.length; t++) {
            nums1[t] = arr[t];
        }
    }

    /**
     * 原地合并：注意利用nums1后面有多余空间
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int len_1 = m - 1;
        int len_2 = n - 1;
        int len = m + n - 1;
        //两个数组合并一共需要m+n个位置，所以原地合并从nums1数组的m+n-1处开始向前插入
        while (len_1 >= 0 && len_2 >= 0) {
            nums1[len--] = nums1[len_1] < nums2[len_2] ? nums2[len_2--] : nums1[len_1--];
        }
        //这里只需要对nums2数组补漏的原因是，nums1在上面的循环结束的时候，一定会遍历完。
        while (len_2 >= 0) {
            nums1[len--] = nums2[len_2--];
        }
    }
}