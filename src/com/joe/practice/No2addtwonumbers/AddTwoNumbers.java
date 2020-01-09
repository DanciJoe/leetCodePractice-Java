package com.joe.practice.No2addtwonumbers;

/**
 * @author : Joe
 * created : 18:17 2019/12/26
 * description :两数相加
 */
public class AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 两个逆序链表“相加”
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode root = new ListNode(0);
        ListNode current = root;
        ListNode p = l1,q = l2;
        int carry = 0;
        while (p != null || q != null){
            //取链表中的同一位
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            //记录进位
            carry = sum / 10;
            //结果如果是两位数，保留个位
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (p != null){
                p = p.next;
            }
            if (q != null){
                q = q.next;
            }
        }
        //最后一位如果有进位，放入下一个链表里
        if (carry > 0){
            current.next = new ListNode(carry);
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(addTwoNumbers(l1,l2).val);
        System.out.println(addTwoNumbers(l1,l2).next.val);
        System.out.println(addTwoNumbers(l1,l2).next.next.val);
    }
}
