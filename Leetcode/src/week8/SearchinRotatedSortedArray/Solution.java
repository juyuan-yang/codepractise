/*
 * Search in Rotated Sorted Array - Mar 3 '12
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */

package week8.SearchinRotatedSortedArray;

public class Solution {
    int[] A;
    int res, target;
    public int search(int[] A, int target) {
        if(A == null || A.length == 0) return -1;
        this.A = A;
        this.res = -1;
        this.target = target;
        bs(0, A.length - 1);
        return this.res;
    }
    
    public void bs(int s, int e){
        if(s > e) return;
        if(s == e){
            if(A[s] == target) res = s;
            return;
        }
        int m = s + (e - s) / 2;
        if(A[s] < A[e]){
            if(target < A[s] || target > A[e]) return;
            if(A[m] == target){
                res = m;
                return;
            } else if(A[m] > target){
                bs(s, m-1);
            } else bs(m+1, e);
            
        } else {
            bs(s, m);
            bs(m + 1, e);
        }
    }
}
