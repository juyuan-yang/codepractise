/*
 * Rotate List - Mar 28 '12
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */

package week6.RotateList;

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
	
    public ListNode rotateRight(ListNode head, int n) {
    	if(head == null || n == 0) return head;
        int total = 1, remain;
        ListNode tail = head, node = head;
        while(tail.next != null){
        	tail = tail.next;
        	total++;
        }
        remain = total - n - 1;
        while(remain > 0){
        	remain --;
        	node = node.next;
        }
        if(remain == 0){
        	tail.next = head;
        	head = node.next;
        	node.next = null;
        }
        return head;
    }
}
