/*
 * Sum Root to Leaf Numbers - Feb 19
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *    1
 *   / \
 *  2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25. 
 */

package week1.SumRootToLeafInt;

public class solution {
    // Definition for binary tree
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    
	public static void main(String[] args) {
		solution omg = new solution();
		TreeNode t1 = omg.new TreeNode(1);
		TreeNode t2 = omg.new TreeNode(2);
		TreeNode t3 = omg.new TreeNode(3);
		TreeNode t4 = omg.new TreeNode(4);
		t2.left = t4;
		t1.right = t3;
		t1.left = t2;
		System.out.println(sumNumbers(t1));
	}
	
    public static int sumNumbers(TreeNode root) {
    	if(root == null) return 0;
        return visitNode(root, 0);
    }
    
    public static int visitNode(TreeNode root, int soFar){
    	int num = soFar * 10 + root.val;
    	int total = 0;
    	boolean leaf = true;
    	if(root.left != null){
    		leaf = false;
    		total += visitNode(root.left, num);
    	}
    	if(root.right != null){
    		leaf = false;
    		total += visitNode(root.right, num);
    	}
    	if(leaf){
    		total += num;
    	}
    	return total;
    }
}
