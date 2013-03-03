/*
 * Flatten Binary Tree to Linked List - Oct 14 '12
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 *       1
 *      / \
 *     2   5
 *    / \   \
 *   3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

 */

package Flattern2tree2List;

import java.util.ArrayList;
import java.util.List;

// get passed at the first time submit it, so Shuang ^_^
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		List<TreeNode> list = new ArrayList<TreeNode>();
		visitNode(root, list);
		for (int i = 0; i < list.size() - 1; i++) {
			list.get(i).left = null;
			list.get(i).right = list.get(i + 1);
		}
		list.get(list.size() - 1).left = null;
		list.get(list.size() - 1).right = null;
	}

	public void visitNode(TreeNode node, List<TreeNode> list) {
		list.add(node);
		if (node.left != null)
			visitNode(node.left, list);
		if (node.right != null)
			visitNode(node.right, list);
	}
}
