/*
 * Binary Tree Inorder Traversal - Aug 27 '12

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */

package week4.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    // Definition for binary tree
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	Stack<Boolean> needExp = new Stack<Boolean>();
    	Stack<TreeNode> visit = new Stack<TreeNode>();
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if(root == null) return res;
    	needExp.push(true);
    	visit.push(root);
    	while(visit.size() > 0){
    		TreeNode node = visit.pop();
    		if(needExp.pop()){
    			if(node.right != null){
    				visit.push(node.right);
    				needExp.push(true);
    			}
    			visit.push(node);
    			needExp.push(false);
    			if(node.left != null){
    				visit.push(node.left);
    				needExp.push(true);
    			}
    		} else res.add(node.val);
    	}
    	return res;
    }
}
