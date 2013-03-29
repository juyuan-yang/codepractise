package validBinarySearchTree;

/**
 * Definition for binary tree*/
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValidBST(root, (long)Integer.MIN_VALUE -1, (long)Integer.MAX_VALUE + 1);
        
    }

    public boolean isValidBST(TreeNode root, long min, long max){
    	if(root == null)
    		return true;

    	if(root.val >= max || root.val <= min) return false;

    	if(!isValidBST(root.left, min, root.val)) return false;

    	if(!isValidBST(root.right, root.val, max)) return false;

    	return true;
    }
}