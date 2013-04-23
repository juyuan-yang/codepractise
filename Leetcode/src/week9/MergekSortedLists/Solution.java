/*
 * Merge k Sorted Lists - Feb 14 '12 - 1099 / 3797

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

package week9.MergekSortedLists;

import java.util.ArrayList;

import all.helper.ListNode;

public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if(lists == null || lists.size() == 0) return null;
		int length = lists.size();
		while(length > 1) {
			for(int i = 0; i < length; i = i + 2){
				if (i + 1 < length) {
					lists.set(i / 2, mergeTwoList(lists.get(i), lists.get(i + 1)));
				} else {
					lists.set(i / 2, lists.get(i));
				}
			}
			length = (length + 1) / 2;
		}
		return lists.get(0);
	}
	
	public ListNode mergeTwoList(ListNode list1, ListNode list2){
		ListNode head = null, cur = null;
		int res;
		do {
			res = compare(list1, list2);
			if(res == -1){
				if(head == null) { 
					head = list1;
					cur = head;
				} else {
					cur.next = list1;
					cur = cur.next;
				}
				list1 = list1.next;
			} else if(res == 1 || res == 0){
				if(head == null){
					head = list2;
					cur = head;
				} else {
					cur.next = list2;
					cur = cur.next;
				}
				list2 = list2.next;
			}
		} while(res != -2);
		return head;
	}
	
	/*
	 * return: -1 if list1.val < list2.val or list2 == null
	 *         0 if equals
	 *         1 if list1.val > list2.val or list1 == null
	 *         -2 if both are null
	 */
	public int compare(ListNode list1, ListNode list2){
		if(list1 != null && list2 != null){
			if(list1.val > list2.val) return 1;
			else if(list1.val == list2.val) return 0;
			else return -1;
		} else if(list1 != null){
			return -1;
		} else if(list2 != null){
			return 1;
		} else 
			return -2;
	}
}
