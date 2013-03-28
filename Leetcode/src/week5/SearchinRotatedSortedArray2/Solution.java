/*
 * Search in Rotated Sorted Array II - Apr 20 '12
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 */

package week5.SearchinRotatedSortedArray2;

public class Solution {
    int[] A;
    int target;
    boolean res;
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 0) return false;
        this.A = A;
        this.res = false;
        this.target = target;
        bs(0, A.length - 1);
        return this.res;
    }
    
    public void bs(int s, int e){
        if(s > e) return;
        if(s == e){
            if(A[s] == target) res = true;
            return;
        }
        int m = s + (e - s) / 2;
        if(A[s] < A[e]){
            if(target < A[s] || target > A[e]) return;
            if(A[m] == target){
                res = true;
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
