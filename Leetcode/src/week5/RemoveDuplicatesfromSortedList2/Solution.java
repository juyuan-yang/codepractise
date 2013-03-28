/*
 * Remove Duplicates from Sorted List II - Apr 22 '12
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */

package week5.RemoveDuplicatesfromSortedList2;

public class Solution {
	 //Definition for singly-linked list.
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode pre = null, node = head.next;
		while(node != null){
			if(pre == null){
				if(node.val == head.val){
					node = node.next;
					while(node != null && node.val == head.val) node = node.next;
					head = node;
				} else 
					pre = head;
			} else {
				if(node.val == pre.next.val){
					node = node.next;
					while(node != null && node.val == pre.next.val) node = node.next;
					pre.next = node;
				} else
					pre = pre.next;
			}
			if(node != null) node = node.next;
		}
		return head;
	}
	
}
