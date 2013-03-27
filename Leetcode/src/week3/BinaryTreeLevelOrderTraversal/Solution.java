/*
 * Binary Tree Level Order Traversal - Sep 29 '12

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]

 */

package week3.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;

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
		
	    ArrayList<ArrayList<Integer>> lists;
	    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	        lists = new ArrayList<ArrayList<Integer>>();
	        if(root != null) visit(root, 0);
	        return lists;
	    }
	    
	    public void visit(TreeNode node, int level){
	        if(lists.size() < level + 1){
	            ArrayList<Integer> list = new ArrayList<Integer>();
	            lists.add(list);
	        }
	        ArrayList<Integer> temp = lists.get(level);
	        temp.add(node.val);
	        if(node.left != null) visit(node.left, level + 1);
	        if(node.right != null) visit(node.right, level + 1);
	    }
}
