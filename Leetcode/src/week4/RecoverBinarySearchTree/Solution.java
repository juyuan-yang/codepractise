/*
 * Recover Binary Search Tree - Sep 1 '12
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */

package week4.RecoverBinarySearchTree;

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
		TreeNode(int x) { val = x; }
	}
	
	// TODO: Morris traversal, so that only use constant space
	TreeNode node1, node2, preNode;
	boolean first;
    public void recoverTree(TreeNode root) {
        first = true;
        node1 = null;
        node2 = null;
        visit(root);
        if(node1 != null && node2 != null){
        	int temp = node1.val;
        	node1.val = node2.val;
        	node2.val = temp;
        }
    }
    
    public void visit(TreeNode node){
    	if(node.left != null) visit(node.left);
    	if(first){
    		first = false;
    	} else {
    		if(preNode.val > node.val){
    			if(node1 == null) node1 = preNode;
    			node2 = node;
    		}
    	}
    	preNode = node;
    	if(node.right != null) visit(node.right);
    }
}
