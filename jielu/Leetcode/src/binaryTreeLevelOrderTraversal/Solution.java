package binaryTreeLevelOrderTraversal;
/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

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
]*/

import java.util.ArrayList;

/**
 * Definition for binary tree*/
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

public class Solution {
	  ArrayList<ArrayList<Integer>> lists ;

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        lists = new ArrayList<ArrayList<Integer>>();
        if(root == null) return lists;
       
        traverse(root, 0);
        
        return lists;
        
    }

    public void traverse(TreeNode root, int level){
    	if(level == lists.size()){
    		// No list is generated for the current level
    		lists.add(new ArrayList<Integer>());
    	}

      lists.get(level).add(root.val);

    	if(root.left != null) traverse(root.left, level + 1);
    	if(root.right != null) traverse(root.right, level + 1);
    }

}