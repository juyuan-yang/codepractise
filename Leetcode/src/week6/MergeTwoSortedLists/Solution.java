/*
 * Merge Two Sorted Lists - Mar 30 '12
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
 */

package week6.MergeTwoSortedLists;

import all.ListNode;

public class Solution {
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, pre = null, node;
        while(l1 != null || l2 != null){
            node = getMin(l1, l2);
            if(pre == null) head = node;
            else pre.next = node;
            pre = node;
            if(node == l1) l1 = l1.next;
            else l2 = l2.next;
        }
        return head;
    }
    
    public ListNode getMin(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null) return null;
        else if(l1 == null) return l2;
        else if(l2 == null) return l1;
        else if(l1.val < l2.val) return l1;
        else return l2;
    }
}
