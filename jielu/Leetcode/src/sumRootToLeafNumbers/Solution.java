package sumRootToLeafNumbers;

import java.util.ArrayList;

/**
 * From Leetcode online judge Problem: Sum Root to Leaf Numbers Given a binary
 * tree containing digits from 0-9 only, each root-to-leaf path could represent
 * a number. An example is the root-to-leaf path 1->2->3 which represents the
 * number 123. Find the total sum of all root-to-leaf numbers. Finished on
 * 3/1/2013
 * 
 * @author jielu
 * 
 */
public class Solution {
	
	public int sumNumbers(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return DFS(root, 0);
	}
	
	public int DFS(TreeNode root, int currentSum){
		int totalSum = 0;
		if(root != null){
			currentSum = currentSum * 10 + root.val;
			if(root.left != null)
				totalSum += DFS(root.left, currentSum);
			
			if(root.right != null){
				totalSum += DFS(root.right, currentSum);
			}
			
			if(root.left == null && root.right == null){
				totalSum += currentSum;
			}
		}
		
		return totalSum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node21 = new TreeNode(2);
		TreeNode node22 = new TreeNode(3);
		TreeNode node31 = new TreeNode(4);
		TreeNode node32 = new TreeNode(5);
		TreeNode node33 = new TreeNode(6);
		
		root.left = node21;
		root.right = node22;
		node21.left = node31;
		node21.right = node32;
		node22.right = node33;
		
		Solution sol = new Solution();
		System.out.println(sol.sumNumbers(root));

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
