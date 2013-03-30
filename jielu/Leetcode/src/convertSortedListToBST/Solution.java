package convertSortedListToBST;

/*Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.*/
/**
 * Definition for singly-linked list.*/
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; next = null; }
 }

/**
 * Definition for binary tree*/
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;

    	if(head.next == null) return new TreeNode(head.val);

    	ListNode preSlow = null, slow = head, fast = head;
    	while(fast != null && fast.next != null){
    		preSlow = slow;
    		slow = slow.next;
    		fast = fast.next.next;
    	}

    	TreeNode root = new TreeNode(slow.val);

    	preSlow.next = null;
    	root.left = sortedListToBST(head);
    	root.right = sortedListToBST(slow.next);

    	return root;

        
    }
}