/*
 * Balanced Binary Tree - Oct 9 '12
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differ by more than 1.
 */

package week2.BalancedBinaryTree;

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

	boolean balanced;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        balanced = true;
        visit(root, 0);
    	return balanced;
    }
    
    public int visit(TreeNode node, int depth){
    	int left = depth, right = depth;
		if(node.left != null)left = visit(node.left, depth + 1);
		if(node.right != null)right = visit(node.right, depth + 1);
		if(left - right > 1 || left - right < -1) balanced = false;
		return (left > right) ? left : right;
    }
}
