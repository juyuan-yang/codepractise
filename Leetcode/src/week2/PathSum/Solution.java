/*
 * Path Sum - Oct 14 '12

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

package week2.PathSum;

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
	
	int sum;
	TreeNode root;
	
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        this.sum = sum;
        this.root = root;
        return visit(root, 0);
    }
    
    public boolean visit(TreeNode node, int now){
    	if(now + node.val == sum && node.left == null && node.right == null) return true;
    	if(node.left != null && visit(node.left, now + node.val)) return true;
    	if(node.right != null && visit(node.right, now + node.val)) return true;
    	return false;
    }
}
