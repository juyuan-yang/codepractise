package binaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;

/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]*/

/**
 * Definition for binary tree*/
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
public class Solution {
	ArrayList<ArrayList<Integer>> lists;
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        lists = new ArrayList<ArrayList<Integer>>();
        if(root == null) return lists;
        
        traverse(root, 0);       
        
        return lists;
    }

    public void traverse(TreeNode root, int level){
    	if(lists.size() == level){
    		lists.add(new ArrayList<Integer>());
    	}

    	if(level % 2 == 0){
    		lists.get(level).add(root.val);
    	}else{
    		lists.get(level).add(0, root.val);
    	}

    	if(root.left != null) traverse(root.left, level + 1);
    	if(root.right != null) traverse(root.right, level + 1);
    }


}