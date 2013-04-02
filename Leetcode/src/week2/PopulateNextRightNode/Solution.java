/*
 * Populating Next Right Pointers in Each Node - Oct 28 '12
 * Given a binary tree
 * 
 *  struct TreeLinkNode {
 *    TreeLinkNode *left;
 *    TreeLinkNode *right;
 *    TreeLinkNode *next;
 *  }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */

package week2.PopulateNextRightNode;

public class Solution {
	// Definition for binary tree with next pointer.
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {

	}
	
	public void connect(TreeLinkNode root) {
		if(root == null) return;
		visit(root);
	}
	
	public void visit(TreeLinkNode node){
		if(node.left != null && node.right != null){
			connect(node.left, node.right);
		}
		if(node.left != null) visit(node.left);
		if(node.right != null) visit(node.right);
	}
	
	public void connect(TreeLinkNode node1, TreeLinkNode node2){
		node1.next = node2;
		if(node1.right != null){
			if(node2.left != null) connect(node1.right, node2.left);
			else if(node2.right != null) connect(node1.right, node2.right);
		} else if(node1.left != null){
			if(node2.left != null) connect(node1.left, node2.left);
			else if(node2.right != null) connect(node1.left, node2.right);
		}
	}
}