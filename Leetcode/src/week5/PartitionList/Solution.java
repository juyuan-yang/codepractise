/*
 * Partition List - Apr 30 '12
Given a linked list and a value x, partition it such that all nodes less than x come before 
nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */

package week5.PartitionList;

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
	
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode preBig = null, preSml = null, preCur = null, cur = head;
        while(cur != null && cur.val < x){ // ignore those small numbers at first
        	preBig = cur;
        	cur = cur.next;
        }
        while(cur != null){
        	while(cur != null && cur.val >= x){ // find the first big number sequence
        		preSml = cur;
        		cur = cur.next;
        	}
        	if(cur != null){ // no need to exchange if no small numbers left
	        	while(cur != null && cur.val < x){ // find the next small number sequence
	        		preCur = cur;
	        		cur = cur.next;
	        	}
        		if(preBig != null){ // don't need to change head
        			preCur.next = preBig.next;
		        	preBig.next = preSml.next;
		        	preSml.next = cur;
		        	preBig = preCur;
        		} else{ // big number comes at the beginning, so need to change head pointer
        			preCur.next = head;
        			head = preSml.next;
        			preSml.next = cur;
        			preBig = preCur;
        		}
        	}
        }
        return head;
    }
}
