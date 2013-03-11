/*
 * Symmetric Tree - Sep 24 '12

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:

    1
   / \
  2   2
   \   \
   3    3

Note:
Bonus points if you could solve it both recursively and iteratively. 
 */

package SymmetricTree;

import java.util.LinkedList;
import java.util.Queue;

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
	// iteratively
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		Queue<TreeNode> lefts = new LinkedList<TreeNode>();
		Queue<TreeNode> rights = new LinkedList<TreeNode>();
		lefts.add(root.left);
		rights.add(root.right);
		while(!lefts.isEmpty()){
			TreeNode left = lefts.poll();
			TreeNode right = rights.poll();
			if(left != null && right != null){
				if(left.val != right.val) return false;
				lefts.add(left.right);
				rights.add(right.left);
				lefts.add(left.left);
				rights.add(right.right);
			} else if(!(left == null && right == null)) return false;
		}
		return true;
	}
	
	// recursively
    public boolean isSymmetric1(TreeNode root) {
        if(root == null) return true;
        return visit(root.left, root.right);
    }
    
    public boolean visit(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        else if(left != null && right != null){
            if(left.val != right.val) return false;
            else return (visit(left.right, right.left) 
                        && visit(left.left, right.right));
        } else return false;
    }
}
