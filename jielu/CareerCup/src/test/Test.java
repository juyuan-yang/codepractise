package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class TreeNode{
	public Integer data;
    public TreeNode leftChild;
    public TreeNode rightChild;
    
    public TreeNode(Integer data){
    	this.data = data;
    }
}

class LinkedListNode{
	public TreeNode data;
	public LinkedListNode next;

	public LinkedListNode(TreeNode data){
	   this.data = data;
	   next = null;
	}
}
public class Test {
	public static boolean isBST(TreeNode root){
	    if(root == null)
	       return false;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while(!queue.isEmpty()){
		   TreeNode node = queue.remove();

		   TreeNode left = node.leftChild;
		   if(left != null){
		      if(left.data > node.data) return false;
		      queue.add(left);
		   }

		   TreeNode right = node.rightChild;
		   if(right != null){
		      if(right.data < node.data) return false;
		      queue.add(right);
		   }
		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		
		node1.leftChild = node2;
		node1.rightChild = node3;
		node2.leftChild = node4;
		node2.rightChild = node5;
		node3.leftChild = node6;
		node5.leftChild = node7;
		node6.rightChild = node8;
		
		
		System.out.println(Test.isBST(node1));
		
		
	

	}

}


