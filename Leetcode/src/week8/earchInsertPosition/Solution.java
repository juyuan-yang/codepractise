/*
 * Search Insert Position - Mar 3 '12 - 473 / 946
Given a sorted array and a target value, return the index if the target is found. If not, 
return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */

package week8.earchInsertPosition;

public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0) return 0;
        int s = 0, e = A.length - 1, m;
        while(s <= e){
            m = s + (e - s) / 2;
            if(A[m] == target) return m;
            else if(A[m] < target) s = m+1;
            else e = m-1;
        }
        return s;
    }
}
