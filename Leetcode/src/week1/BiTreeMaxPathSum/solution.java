/*
 * Binary Tree Maximum Path Sum - Nov 8 '12
 * 
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * 
 * For example:
 * Given the below binary tree,
 *     1
 *    / \
 *   2   3
 * 
 * Return 6. 
 */

package week1.BiTreeMaxPathSum;

public class solution {
    // Definition for binary tree
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public int max, maxNode;
    
    // return the max value of a half-path got from this node.
    // half-path: not like 'v', but like '|'
    public int visitNode(TreeNode node){
        int left = 0, right = 0;
        if(node.left != null) left = visitNode(node.left);
        if(node.right != null) right = visitNode(node.right);
        if(node.val + left + right > max) max = node.val + left + right;
        if(node.val > maxNode) maxNode = node.val; 
        
        int toReturn = getMax(left, right);
        toReturn = getMax(node.val, toReturn + node.val);
        return getMax(toReturn, 0);
    }
    
    public int getMax(int num1, int num2){
        return (num1 > num2) ? num1 : num2;
    }
    
    public int maxPathSum(TreeNode root) {
        max = 0;
        if(root == null) return 0;
        maxNode = root.val;
        visitNode(root);
        if(max == 0 && maxNode < 0) return maxNode;
        return max;
    }
    
	public static void main(String[] args) {
		solution s = new solution();
		TreeNode t1 = s.new TreeNode(1);
		TreeNode t2 = s.new TreeNode(-2);
		TreeNode t3 = s.new TreeNode(-3);
		TreeNode t4 = s.new TreeNode(1);
		TreeNode t5 = s.new TreeNode(3);
		TreeNode t6 = s.new TreeNode(-2);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
//		System.out.println(maxPathSum(t1));
	}
}
