/*
 * Remove Nth Node From End of List - Jan 28 '12 - 1122 / 2927
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */

package week10.RemoveNthNodeFromEndofList;

import all.helper.ListNode;

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) return null;
		int k = 0;
		ListNode cur = head, pre = head;
		
		while(k < n){
			cur = cur.next;
			k++;
		}
		
		if(cur == null) head = head.next;
		else {
			cur = cur.next;
			while(cur != null){
				cur = cur.next;
				pre = pre.next;
			}
			pre.next = pre.next.next;
		}
		return head;
	}
}
