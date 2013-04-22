/*
 * Swap Nodes in Pairs - Feb 15 '12 - 1032 / 2373

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

package week9.SwapNodesinPairs;

import all.helper.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode node = head, pre = null, next, tail;
        while(node != null && node.next != null){
            next = node.next;
            tail = next.next;
            
            node.next = tail;
            next.next = node;
            if(pre == null){
                head = next;
            } else {
                pre.next = next;
            }
            pre = node;
            node = tail;
        }
        return head;
    }
}
