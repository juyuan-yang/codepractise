/*
 * Unique Binary Search Trees - Aug 27 '12

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */

package week4.UniqueBinarySearchTrees;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int numTrees(int n) {
    	if(n == 0) return 0;
        int num[] = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        for(int i = 2; i <= n; i++){
        	num[i] = 0;
        	for(int j = 1; j <= i; j++){
        		num[i] += num[j - 1] * num[i - j];
        	}
        }
        return num[n];
    }
}
