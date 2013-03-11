/*
 * Path Sum II - Oct 14 '12

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

return

[
   [5,4,11,2],
   [5,8,4,5]
]

 */

package PathSum2;

import java.util.ArrayList;

// To store the current path, I used list but got Time Limit Exceed
// So I switch to int[], and the capacity of it is set arbitrarily, just big enough to pass tests
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
	
	int sum;
	TreeNode root;
	ArrayList<ArrayList<Integer>> res;
	int[] visited;
	
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		this.res = new ArrayList<ArrayList<Integer>>();
		this.visited = new int[1000];
        this.sum = sum;
        this.root = root;
        
        if(root != null) visit(root, 0, 0);
        return res;
    }
    
    public void visit(TreeNode node, int now, int depth){
    	visited[depth++] = node.val;
    	if(now + node.val == sum && node.left == null && node.right == null){
    		ArrayList<Integer> one = new ArrayList<Integer>(depth);
    		for(int i = 0; i < depth; i++) one.add(visited[i]);
    		res.add(one);
    	}
    	if(node.left != null) visit(node.left, now + node.val, depth);
    	if(node.right != null) visit(node.right, now + node.val, depth);
    }
}
