/*
 * Remove Element - Feb 16 '12 - 506 / 993
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */

package week8.RemoveElement;

public class Solution {
    public int removeElement(int[] A, int elem) {
        int cur = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != elem) A[cur++] = A[i];
        }
        return cur;
    }
}
