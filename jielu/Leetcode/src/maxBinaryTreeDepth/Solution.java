package maxBinaryTreeDepth;

import java.util.Stack;

/**
 * Definition for binary tree*/
  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
 * Finished on 3/28/2013
 * @author jielu
 *
 */
public class Solution {
	/* Recursion version */
    /*
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        int max = 0;
        if(root.left != null) max = Math.max(max, maxDepth(root.left));

        if(root.right != null) max = Math.max(max, maxDepth(root.right));

        return max + 1;
    }*/

     /* Non-Recursion version */
	public int maxDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return 0;

		Stack<TreeNode> paths = new Stack<TreeNode>();
		int depth = 1;
		int maxDepth = 0;

		paths.push(root);
		while (!paths.isEmpty()) {
			TreeNode node = paths.peek();
			while (node.left != null) {
				node = node.left;
				paths.push(node);
				depth++;

			}

			if(node.right != null){
                paths.push(node.right);
                depth ++;
            }else{
                maxDepth = Math.max(maxDepth, depth);
                TreeNode pNode = paths.pop();
                depth --;
                TreeNode tNode;
                while(!paths.isEmpty() && (pNode == (tNode=paths.peek()).right || (pNode == tNode.left && tNode.right == null))){
                    pNode = paths.pop();
                    depth --;
                }

                if(!paths.isEmpty()){
                    paths.push(paths.peek().right);
                    depth ++;
                }

            }
		}

		return maxDepth;
	}
}