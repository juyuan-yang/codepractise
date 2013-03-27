/*
 * Binary Tree Zigzag Level Order Traversal - Sep 29 '12

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

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
]

 */

package week3.BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;

public class Solution {

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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        lists = new ArrayList<ArrayList<Integer>>();
        if(root != null) visit(root, 0);
        for(int i = 1; i < lists.size(); i = i + 2){
        	ArrayList<Integer> temp = lists.get(i);
        	ArrayList<Integer> newList = new ArrayList<Integer>();
        	for(int j = temp.size() - 1; j >= 0; j--) newList.add(temp.get(j));
        	temp.clear();
        	temp.addAll(newList);
        }
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
