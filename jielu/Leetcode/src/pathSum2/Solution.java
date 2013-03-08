package pathSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * From Leetcode online judge Problem: Path Sum II Given a binary tree and a
 * sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example: Given the below binary tree and sum = 22, 5 / \ 4 8 / / \ 11 13
 * 4 / \ / \ 7 2 5 1 return [ [5,4,11,2], [5,8,4,5] ] Finished on 3/7/2013
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public static void main(String[] args){
		TreeNode node5 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node11 = new TreeNode(11);
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		TreeNode node8 = new TreeNode(8);
		TreeNode node13 = new TreeNode(13);
		TreeNode node42 = new TreeNode(4);
		TreeNode node52 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		
		node5.left = node4;
		node5.right = node8;
		node4.left = node11;
		node8.left = node13;
		node8.right = node42;
		node11.left = node7;
		node11.right = node2;
		node42.left = node52;
		node42.right = node1;
		
		Solution.pathSum(node5, 20);
	}
	
	// Try non-recursive way, time limit exceeded too.....
	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> allPaths = new ArrayList<ArrayList<Integer>>();
		int curSum = 0;
		int[] path = new int[100];
		byte[] allChildrenVisited = new byte[100];
		int curIndex = 0;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while(node != null || !stack.isEmpty()){
			while(node != null){
				//Add the node to stack
				stack.push(node);
				
				//Add node value to current sum
				curSum += node.val;
				
				//Add the node data to path
				path[curIndex] = node.val;
				//Update visit flag for the node
				allChildrenVisited[curIndex] = 0;
				curIndex ++;
				
				//If it is a leaf node, check whether current sum equals to the sum
				if(node.left == null && node.right == null){
					if(curSum == sum){
						ArrayList<Integer> onePath = new ArrayList<Integer>();
						for(int i=0; i<curIndex; i++){
							onePath.add(path[i]);
						}
						allPaths.add(onePath);
					}
				}
				
				node = node.left;
			}
			
			//If the peek node has no left node, pop it from stack
			node = stack.pop();
			curIndex --;
			curSum -= node.val;
			
			//If the peek node has right node, add the node back to stack again, and update current node to its right child
			if(node.right != null && allChildrenVisited[curIndex] == 0){
				stack.push(node);
				path[curIndex] = node.val;
				allChildrenVisited[curIndex] = 1;
				curIndex ++;
				curSum += node.val;
				
				node = node.right;
			}else{
				node = null;
			}
			
		}

		return allPaths;

	}

	// Using ArrayList to store each path results in "Time Limit Exceeded"
	// exception.
	// private ArrayList<ArrayList<Integer>> allPaths;
	// private int sum;
	// private int[] visited;
	//
	// public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	// // Start typing your Java solution below
	// // DO NOT write main() function
	// this.allPaths = new ArrayList<ArrayList<Integer>>();
	// this.sum = sum;
	// this.visited = new int[100];
	// if(root == null)
	// return allPaths;
	//
	// DFS(root, 0, 0);
	//
	// return allPaths;
	// }
	//
	// public void DFS(TreeNode root, int curSum, int curDepth) {
	// visited[curDepth ++] = root.val;
	// curSum += root.val;
	// if (root.left == null && root.right == null) {
	// if (curSum == sum){
	// ArrayList<Integer> path = new ArrayList<Integer>(curDepth);
	// for(int i=0; i<curDepth; i++){
	// path.add(visited[i]);
	// }
	// allPaths.add(path);
	// }
	// }
	//
	// if (root.left != null) {
	// DFS(root.left, curSum, curDepth);
	// }
	//
	// if (root.right != null) {
	// DFS(root.right, curSum, curDepth);
	// }
	//
	// }
}
