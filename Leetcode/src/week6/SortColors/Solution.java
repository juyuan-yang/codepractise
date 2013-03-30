/*
 * Sort Colors - Apr 9 '12

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem. 
 */

package week6.SortColors;

public class Solution {
    public void sortColors(int[] A) {
        if(A == null || A.length == 0) return;
        int one = 0, two = 0, zero = 0, cur = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0) zero++;
            else if(A[i] == 1) one++;
            else if(A[i] == 2) two++;
        }
        for(int i = 0; i < zero; i++) A[cur++] = 0;
        for(int i = 0; i < one; i++) A[cur++] = 1;
        for(int i = 0; i < two; i++) A[cur++] = 2;
    }
}
