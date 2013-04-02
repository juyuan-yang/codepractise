/*
 * Convert Sorted Array to Binary Search Tree - Oct 2 '12
Given an array where elements are sorted in ascending order, 
convert it to a height balanced BST.
 */

package week2.ConvertSortedArraytoBinarySearchTree;

// I write the code in Leetcode editor, and get accepted, so happy! ^_^ -.-!!
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
	
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0) return null;
        TreeNode root = new TreeNode(num[num.length / 2]);
        if(0 < num.length/2)
            visit(root, 0, num.length/2-1, num, true);
        if(num.length/2+1 < num.length)
            visit(root, num.length/2+1, num.length-1, num, false);
        return root;
    }
    
    public void visit(TreeNode father, int s, int t, int[] num, boolean left){
        int m = (t-s)/2 + s;
        TreeNode node = new TreeNode(num[m]);
        if(left) father.left = node;
        else father.right = node;
        if(s < m)
            visit(node, s, m-1, num, true);
        if(m < t)
            visit(node, m+1, t, num, false);
    }
}
