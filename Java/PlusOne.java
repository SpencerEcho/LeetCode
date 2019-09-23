import java.util.Arrays;

// Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
// You may assume the integer does not contain any leading zero, except the number 0 itself.

// Example 1:

// Input: [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Example 2:

// Input: [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.

public class PlusOne {
    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        int[] digits_1 = {9,9,9};
        int[] digits_2 = {4,3,2,1};
        System.out.println(Arrays.toString(solution.plusOne(digits_1)));
        System.out.println(Arrays.toString(solution.plusOne(digits_2)));
    }

    /**
     * 注意加1后，数组溢出问题，例如：999+1 = 1000
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int flag = 1;
        int temp = 0;
        //从最后一个元素开始，如果元素加1后满10，循环继续，并向前进一位，否则跳出循环
        for (int i=digits.length-1; i>=0 && flag == 1; i--) {
            temp = digits[i] + flag;
            digits[i] = temp % 10;
            flag = temp / 10;
        }
        //如果数组第一个元素加1后满10，即flag==1，则数组需要扩容
        if (flag == 1) {
            int[] new_digits = new int[digits.length+1];
            new_digits[0] = flag;
            for (int i=0; i<digits.length; i++) {
                new_digits[i+1] = digits[i];
            }
            return new_digits;
        }
        return digits;
    }
}