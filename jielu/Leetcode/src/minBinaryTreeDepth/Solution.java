package minBinaryTreeDepth;

import java.util.Stack;

/**
 * Definition for binary tree
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the 
 * shortest path from the root node down to the nearest leaf node.
 * Finished on 3/28/2013
 * @author jielu
 *
 */
public class Solution {
	/* Recursion version */
	/*
	 * public int minDepth(TreeNode root) { // Start typing your Java solution
	 * below // DO NOT write main() function if(root == null) return 0;
	 * 
	 * if(root.left == null && root.right == null) return 1;
	 * 
	 * int min = Integer.MAX_VALUE; if(root.left != null) min = Math.min(min,
	 * minDepth(root.left));
	 * 
	 * if(root.right != null) min = Math.min(min, minDepth(root.right));
	 * 
	 * return min + 1;
	 * 
	 * }
	 */

	/* Non-Recursion version */
	public int minDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return 0;

		Stack<TreeNode> paths = new Stack<TreeNode>();
		int depth = 1;
		int minDepth = Integer.MAX_VALUE;

		paths.push(root);
		while (!paths.isEmpty()) {
			TreeNode node = paths.peek();
			while (node.left != null) {
				node = node.left;
				paths.push(node);
				depth++;

			}

			if (node.right != null) {
				paths.push(node.right);
				depth++;
			} else {
				minDepth = Math.min(minDepth, depth);
				TreeNode pNode = paths.pop();
				depth--;
				TreeNode tNode;
				while (!paths.isEmpty()
						&& (pNode == (tNode = paths.peek()).right || (pNode == tNode.left && tNode.right == null))) {
					pNode = paths.pop();
					depth--;
				}

				if (!paths.isEmpty()) {
					paths.push(paths.peek().right);
					depth++;
				}

			}
		}

		return minDepth;

	}
}