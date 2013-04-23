/*
 * Reverse Nodes in k-Group - Feb 16 '12 / 721 / 2181

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */

package week9.ReverseNodesinkGroup;

import all.helper.ListNode;

public class Solution {
	// fuck, spend a lot of time... Can you do it correctly the first time?
    public ListNode reverseKGroup(ListNode head, int k) {
    	ListNode start = null, node = head, tail = null, pre = null, cur, preStart = null;
		int i;
		while(node != null){
			cur = node;
			for(i = 0; i < k && cur != null; i++) 
				if(cur != null) cur = cur.next;
			if(i < k){
				if(preStart != null)
					preStart.next = node;
                break;
			} else {
                i = 0;
                start = node;
                pre = null;
				while(node != null && i < k){
					tail = node.next;
					node.next = pre;
					pre = node;
					node = tail;
                    i++;
				}
				if(preStart == null)
					head = pre;
				else 
					preStart.next = pre;
                preStart = start;
			}
		}
		return head;
    }
}
