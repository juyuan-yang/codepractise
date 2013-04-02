/*
 * Convert Sorted List to Binary Search Tree - Oct 3 '12
Given a singly linked list where elements are sorted in ascending order, 
convert it to a height balanced BST.
 */

package week2.ConvertSortedListtoBinarySearchTree;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
	 	ListNode(int x) { val = x; next = null; }
	}
	 
	ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        cur = head;
        return visit(0, length - 1);
    }
    
    public TreeNode visit(int s, int t){
        int m = (t - s) / 2 + s;
        TreeNode left = null, node, right = null;
        if(s < m) left = visit(s, m - 1);
        node = new TreeNode(cur.val);
        cur = cur.next;
        if(m < t) right = visit(m + 1, t);
        node.left = left;
        node.right = right;
        return node;
    }
}
