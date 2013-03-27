package week3.ConstructBinaryTreefromPreandInorderTraversal;

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
    int[] preorder, inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null 
            || preorder.length != inorder.length) return null;
        this.preorder = preorder;
        this.inorder = inorder;
        return buildNode(0, inorder.length - 1, 0, inorder.length - 1);
    }
    // preorder: s1 t1, inorder: s2 t2
    public TreeNode buildNode(int s1, int t1, int s2, int t2){
        if(s1 > t1) return null;
        TreeNode node = new TreeNode(preorder[s1]);
        for(int i = s2; i <= t2; i++){
            if(inorder[i] == preorder[s1]){
                if(s2 < i) node.left = buildNode(s1+1, i-s2+s1, s2,i-1);
                if(i < t2) node.right = buildNode(t1-t2+i+1, t1, i+1,t2);
                break;
            }
        }
        return node;
    }
}
