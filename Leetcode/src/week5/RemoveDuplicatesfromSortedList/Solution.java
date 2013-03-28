/*
 * Remove Duplicates from Sorted List - Apr 22 '12
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */

package week5.RemoveDuplicatesfromSortedList;

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
        if(head == null) return head;
        ListNode node = head.next, pre = head;
        
        while(node != null){
            if(node.val != pre.val){
                pre.next = node;
                pre = pre.next;
            }
            node = node.next;
        }
        pre.next = null;
        return head;
    }
}
