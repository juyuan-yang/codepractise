/*
 * Same Tree - Sep 3 '12

Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value. 
 */

package week3.SameTree;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return visit(p, q);        
    }
    public boolean visit(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        else if(p != null && q != null){
            if(p.val != q.val) return false;
            else return (visit(p.left, q.left) && visit(p.right, q.right));
        } else return false;
    }
}
