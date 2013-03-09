package ConstructBinaryTreefromInandPostorderTraversal;

public class Solution {

	/**
	 * @param args
	 */
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
    int[] postorder, inorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null 
            || postorder.length != inorder.length) return null;
        this.postorder = postorder;
        this.inorder = inorder;
        return buildNode(0, inorder.length - 1, 0, inorder.length - 1);
    }

    // postorder: s1 t1, inorder: s2 t2
    public TreeNode buildNode(int s1, int t1, int s2, int t2){
        if(s1 > t1) return null;
        TreeNode node = new TreeNode(postorder[t1]);
        for(int i = s2; i <= t2; i++){
            if(inorder[i] == postorder[t1]){
                if(s2 < i) node.left = buildNode(s1, i-s2+s1-1, s2,i-1);
                if(i < t2) node.right = buildNode(t1-t2+i, t1-1, i+1,t2);
                break;
            }
        }
        return node;
    }
}
