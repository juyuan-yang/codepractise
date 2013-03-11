/*
 * Maximum Depth of Binary Tree - Sep 30 '12

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

package MaximumDepthofBinaryTree;

public class Solution {

	/**
	 * @param args
	 */
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
    int max;
    public int maxDepth(TreeNode root) {
        max = 0;
        if(root == null) return 0;
        visit(root, 0);
        return max;
    }
    
    public void visit(TreeNode node, int depth){
        depth++;
        if(depth > max) max = depth;
        if(node.left != null) visit(node.left, depth);
        if(node.right != null) visit(node.right, depth);
    }
}
