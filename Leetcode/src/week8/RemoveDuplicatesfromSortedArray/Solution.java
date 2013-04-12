/*
 * Remove Duplicates from Sorted Array - Feb 16 '12

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2]. 
 */

package week8.RemoveDuplicatesfromSortedArray;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0) return 0;
        int num = 1;
        for(int i = 1; i < A.length; i++) if(A[i] != A[i-1]) num++;
        
        int pos = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i] != A[i-1]){ // interesting here
                A[pos++] = A[i];
            }
        }
        return num;
    }
}
