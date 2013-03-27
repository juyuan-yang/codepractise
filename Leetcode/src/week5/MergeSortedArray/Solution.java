/*
 * Merge Sorted Array - May 20 '12

Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. 
The number of elements initialized in A and B are m and n respectively.
 */

package week5.MergeSortedArray;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1;
        for(int t = m + n - 1; t >= 0; t--){
            if(i >= 0 && j >= 0){
                if(A[i] > B[j]) A[t] = A[i--];
                else A[t] = B[j--];
            } else if(i >= 0){
                A[t] = A[i--];
            } else if(j >= 0){
                A[t] = B[j--];
            }
        }
    }
}
