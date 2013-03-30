package balancedBinaryTree;

/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differ by more than 1.*/

/**
 * Definition for binary tree */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
	boolean result;
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return true;

        result = true;
        getHeight(root);
        return result;
    }

    // Use postorder traversal
    public int getHeight(TreeNode root){
    	if(root.left == null && root.right == null) return 1;

    	int leftHeight = 0, rightHeight = 0;
    	if(root.left != null) leftHeight = getHeight(root.left);
    	if(root.right != null) rightHeight = getHeight(root.right);

    	if(Math.abs(leftHeight - rightHeight) > 1) result = false;

    	return Math.max(leftHeight, rightHeight) + 1;

    }


}