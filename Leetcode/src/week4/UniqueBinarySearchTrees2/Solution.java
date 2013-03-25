/*
 * Unique Binary Search Trees II - Aug 27 '12

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */

package week4.UniqueBinarySearchTrees2;

import java.util.ArrayList;

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
		TreeNode(int x) { val = x; left = null; right = null; }
	}

    public ArrayList<TreeNode> generateTrees(int n) {
    	return visit(1, n);
    }
    
    public ArrayList<TreeNode> visit(int s, int t){
    	ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(s > t) {  
        	// 2b test case? expected: [{}], output: [] 
//        	TreeNode node = new TreeNode(0);
        	res.add(null);
            return res;
        }
    	if(s == t){
    		TreeNode node = new TreeNode(s);
    		res.add(node);
    		return res;
    	}
    	for(int i = s + 1; i < t; i++){
    		ArrayList<TreeNode> left = visit(s, i-1);
    		ArrayList<TreeNode> right = visit(i+1, t);
    		for(TreeNode node1 : left){
    			for(TreeNode node2 : right){
    				TreeNode node = new TreeNode(i);
    				node.left = node1;
    				node.right = node2;
    				res.add(node);
    			}
    		}
    	}
    	ArrayList<TreeNode> left = visit(s, t-1);
    	for(TreeNode leave : left){
    		TreeNode node = new TreeNode(t);
    		node.left = leave;
    		res.add(node);
    	}
		ArrayList<TreeNode> right = visit(s+1, t);
		for(TreeNode leave : right){
			TreeNode node = new TreeNode(s);
			node.right = leave;
			res.add(node);
		}
    	return res;
    }
}
