/*
 * Reverse Linked List II - Jun 27 '12

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ? m ? n ? length of list. 
 */

package week4.ReverseLinkedList2;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 //Definition for singly-linked list.
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = head, next, tail = null, start, pre = head;
    	int i = 1;
    	while(i < m){
    		i++;
    		pre = node;
    		node = node.next;
    	}
    	start = node;
    	while(node != null && i <= n){
    		i++;
    		next = node.next;
    		node.next = tail;
    		tail = node;
    		node = next;
    	}
    	start.next = node;
    	if(m != 1)pre.next = tail;
    	else return tail;
    	return head;
    }
}
