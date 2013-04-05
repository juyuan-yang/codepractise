package createTreeWithInAndPostOrder;
/*Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

/**
 * Definition for binary tree*/
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(postorder.length == 0) return null;
        int length = postorder.length;
        return create(postorder, 0, length -1, inorder, 0, length - 1);
        
    }

    public TreeNode create(int[] postorder, int poststart, int postend, int[] inorder, int instart, int inend){
        if(instart > inend)
        	return null;

        if(instart == inend)
        	return new TreeNode(inorder[instart]);

    	//postorder[postend] is root node
    	int index = -1;
    	for(int i=instart; i<=inend; i++){
    		if(inorder[i] == postorder[postend]){
    			index = i;
    			break;
    		}
    	}

    	int rightLength = inend - index;
    	TreeNode root = new TreeNode(postorder[postend]);

        root.right = create(postorder, postend - rightLength, postend -1, inorder, index + 1, inend);
    	root.left = create(postorder, poststart, postend - rightLength -1, inorder, instart, index - 1);
    	

    	return root;
    }
}