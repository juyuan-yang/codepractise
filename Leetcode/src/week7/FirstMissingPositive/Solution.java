/*
 * First Missing Positive - Mar 8 '12 - 551 / 1865
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */

package week7.FirstMissingPositive;

public class Solution {
	public int firstMissingPositive(int[] A) {
		if(A == null || A.length == 0) return 1;
		for(int i = 0; i < A.length; i++){
			while(A[i] != i + 1){
				if(A[i] <= 0 || A[i] > A.length || A[i] == A[A[i]-1]) 
					break;
				int temp = A[i];
				A[i] = A[temp-1];
				A[temp-1] = temp;
			}
		}
		
		for(int i = 0; i < A.length; i++)
			if(A[i] != i+1) return i+1;
		
		return A.length + 1;
	}
	
	// use O(n) space
	public int firstMissingPositive1(int[] A) {
		if(A == null || A.length == 0) return 1;
		boolean[] visit = new boolean[A.length];
		
		for(int i = 0; i < A.length; i++) {
			if(A[i] > 0 && A[i] <= A.length)
				visit[A[i] - 1] = true;
		}
		
		for(int i = 0; i < A.length; i++)
			if(visit[i] == false) return i+1;
		
		return A.length + 1;
	}
}
