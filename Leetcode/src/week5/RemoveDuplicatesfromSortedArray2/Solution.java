/*
 * Remove Duplicates from Sorted Array II - Apr 19 '12

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3]. 

Do not allocate extra space for another array, you must do this in place with constant memory.
 */

package week5.RemoveDuplicatesfromSortedArray2;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0) return 0;
        if(A.length == 1) return 1;
        int num = 2;
        
        for(int i = 2; i < A.length; i++){
            if(!(A[i] == A[i-1] && A[i] == A[i-2])) num++;
        }
        
        int pos = 2, pre = A[0];
        for(int i = 2; i < A.length; i++){
            if(A[i] != A[i-1] || A[i] != pre){
                pre = A[i-1]; // very interesting! Can you write it correct next time?
                A[pos++] = A[i];
            }
            else pre = A[i-1];
        }
        return num;
    }

}
