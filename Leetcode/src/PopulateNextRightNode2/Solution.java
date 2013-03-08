/*
 * Populating Next Right Pointers in Each Node II - Oct 28 '12
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */

package PopulateNextRightNode2;

// A perfect and elegant solution: 
// http://discuss.leetcode.com/questions/282/populating-next-right-pointers-in-each-node-ii
// Key point: for current level, reuse the next chain from previous level
public class Solution {
	public static void main(String[] args) {
		
	}
	// Definition for binary tree with next pointer.
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
    public void connect(TreeLinkNode root) {       
        while(root != null){
        	TreeLinkNode nextStart = null;
            TreeLinkNode prev = null;
            
            for( ; root != null; root = root.next){
            	if(nextStart == null) nextStart = 
            			(root.left != null) ? root.left : root.right;
            	
            	if(root.left != null){
            		if(prev != null) prev.next = root.left;
            		prev = root.left;
            	}
            	
            	if(root.right != null){
            		if(prev != null) prev.next = root.right;
            		prev = root.right;
            	}
            }
            root = nextStart;
        }
    }
}
