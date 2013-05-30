/*
Add Two Numbers - Nov 1 '11 - 3765 / 12055
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */

package week11.AddTwoNumbers;

import all.helper.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: juyuan.yang
 * Date: 5/29/13
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null, temp = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int n1 = 0, n2 = 0;
            if(l1 != null){
                n1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                n2 = l2.val;
                l2 = l2.next;
            }
            int add = n1 + n2 + carry;
            ListNode item = new ListNode(add % 10);
            carry = add / 10;
            if(temp == null){
                res = item;
                temp = item;
            } else {
                temp.next = item;
                temp = item;
            }
        }
        if(carry > 0){
            ListNode item = new ListNode(1);
            temp.next = item;
        }
        if(res == null){
            res = new ListNode(0);
        }
        return res;
    }
}
