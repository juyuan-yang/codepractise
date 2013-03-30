package convertSortedArrayToBST;

/*Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for binary tree*/
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null || num.length == 0) return null;

        return create(num, 0, num.length - 1);
        
    }

    public TreeNode create(int[] num, int start, int end){
    	if(start == end) return new TreeNode(num[start]);

    	int mid = (start + end) / 2;
    	TreeNode root = new TreeNode(num[mid]);
    	if(start < mid) root.left = create(num, start, mid-1);
    	if(end > mid) root.right = create(num, mid+1, end);

    	return root;
    }
}