/*
 * Validate Binary Search Tree - Aug 31 '12

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

 */

package week4.ValidateBinarySearchTree;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    // Definition for binary tree
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return visit(root, -1, -1);
    }
    
    public boolean visit(TreeNode node, int low, int high){
        if(low != -1 && node.val <= low) return false;
        if(high != -1 && node.val >= high) return false;
        boolean res = true;
        if(node.left != null){
            if(!visit(node.left, low, node.val)) res = false;
        }
        if(node.right != null){
            if(!visit(node.right, node.val, high)) res = false;
        }
        return res;
    }
}
