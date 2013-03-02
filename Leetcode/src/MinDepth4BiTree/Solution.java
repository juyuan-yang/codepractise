/*
 * Minimum Depth of Binary Tree - Oct 10 '12

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
package MinDepth4BiTree;

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
	
	int min;
	
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        this.min = 1000000;
        visit(root, 0);
        return min;
    }
    
    public void visit(TreeNode node, int depth){
    	depth++;
    	if(node.left == null && node.right == null){
    		if(depth < min) min = depth;
    	}
    	if(node.left != null) visit(node.left, depth);
    	if(node.right != null) visit(node.right, depth);
    }
}
