package createTreeWithPreAndInOrder;
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(preorder.length == 0) return null;
        int length = preorder.length;
        return create(preorder, 0, length -1, inorder, 0, length - 1);
        
    }

    public TreeNode create(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){
        if(prestart == preend)
        	return new TreeNode(preorder[prestart]);

        if(prestart > preend)
        	return null;

    	//preorder[prestart] is root node
    	int index = -1;
    	for(int i=instart; i<=inend; i++){
    		if(inorder[i] == preorder[prestart]){
    			index = i;
    			break;
    		}
    	}

    	int leftLength = index - instart;
    	TreeNode root = new TreeNode(preorder[prestart]);

    	root.left = create(preorder, prestart+1, prestart + leftLength, inorder, instart, index - 1);
    	root.right = create(preorder, prestart + leftLength + 1, preend, inorder, index + 1, inend);

    	return root;
    }
}