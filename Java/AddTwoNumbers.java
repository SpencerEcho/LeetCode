
// You are given two non-empty linked lists representing two non-negative integers. 
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example:

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.

  /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        // int[] arr_1 = {2,4,3};
        // int[] arr_2 = {5,6,4};
        int[] arr_1 = {9};
        int[] arr_2 = {1,9,9,9,9,9,9,9,9,9};
        // int[] arr_1 = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        // int[] arr_2 = {5,6,4};

        ListNode list_1 = solution.makeList(arr_1);
        ListNode list_2 = solution.makeList(arr_2);
        
        
        // solution.addTwoNumbers(list_1, list_2);
        System.out.println(solution.addTwoNumbers_1(list_1, list_2).toStr());
        System.out.println(solution.addTwoNumbers_2(list_1, list_2).toStr());

    }

    /**
     * 实现的核心思想是，将两个链表分别转换成10进制数字，并相加，再将结果重新转成链表
     * 将结果转成链表的过程中，数字的对10取余的结果作为新的节点值、原数字小数点左移一位（除以10）后，重新进入循环，直到原数字变为0为止
     * 
     * 这个方法在数据边界不明确的情况下不可取。因为两数直接相加逻辑上没问题，但是会遇到类型溢出的问题。
     * 比如，用int型遇到Integer.MAX_VALUE（2147483647）边界
     * long遇到Long.MAX_VALUE(9223372036854775807)
     * double遇到Double.MAX_VALUE(1.7976931348623157e+308)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        int n = 0;
        int num_1 = 0;
        int num_2 = 0;
        ListNode sumListNode = null;
        ListNode tempNode = null;
        //将l1链表的节点转成10进制数字
        while (l1 != null) {
            num_1 += l1.val * Math.pow(10, n);
            l1 = l1.next;
            n++;
        }
        n = 0;
        //将l2链表的节点转成10进制数字
        while (l2 != null) {
            num_2 += l2.val * Math.pow(10, n);
            l2 = l2.next;
            n++;
        }
        int num_3 = num_1 + num_2;
        if (num_3 == 0) {
            sumListNode = new ListNode(0);
        }
        //将前两个链表的转化结果相加后，转成新的链表
        while (num_3 != 0) {
            //取余结果存入新的节点
            int s = num_3 % 10;
             if (sumListNode == null) {
                sumListNode = new ListNode(s);
                tempNode = sumListNode;
             } else {
                tempNode.next = new ListNode(s);
                tempNode = tempNode.next;
             }
             //原数字小数点左移一位
             num_3 = num_3/10;

        }
        return sumListNode;
    }

    /**
     * 该实现利用了十进制数相加的原理：两数之和大于等于10要向前进一位
     * 对应到题目中，就是前面的节点的和大于10，后面的节点的和要多加1，因为链表顺序是10进制数的逆向排列
     * @param l1
     * @param l2
     * @return
     */
    private ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        ListNode hNode = null;
        ListNode tNode = null;
        // int sum = 0;
        //是否向后面节点进一位标识
        int flag = 0;
        //将l1、l2中的对应节点相加，如果l1或l2还有剩余节点，剩余直接存入新的节点
        //right!=0，这个判断条件，只有在l1、l2中的节点全部遍历完后，最后一次相加的和大于10，才会用到
        while (l1 != null || l2 != null || flag != 0) {
            int sum = 0;
            //防止l1比l2长，或两个链表一样长，但最后一次相加的和超过10
            if (l1 != null) {
                sum += l1.val;
            }
            //防止l2比l1长，或两个链表一样长，但最后一次相加的和超过10
            if (l2 != null) {
                sum += l2.val;
            }
            //本次相加的结果，要加上前一次节点的和大于等于10时候的进位
            sum += flag;
            //相加的结果超过10，向后面进一位，否则，不需要
            if(sum >= 10) {
                sum = sum % 10;
                flag = 1;
            } else {
                flag = 0;
            }
            if (hNode == null) {
                hNode = new ListNode(sum);
                tNode = hNode;
            } else {
                tNode.next = new ListNode(sum);
                tNode = tNode.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return hNode;
    }

    private ListNode makeList(int[] arr) {
        ListNode head = null;
        ListNode temp = null;
        for (int n : arr) {
            if (head == null) {
                head = new ListNode(n);
                temp = head;
            } else {
                temp.next = new ListNode(n);
                temp = temp.next;
            }
        }
        return head;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        String toStr() {
            String str = "";
            ListNode temp = this;
            while (temp != null) {
                str += temp.val;
                temp = temp.next;
            }
            return str;
        }
    }
}
