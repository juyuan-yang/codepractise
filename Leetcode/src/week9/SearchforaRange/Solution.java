/*
 * Search for a Range - Mar 3 '12 - 915 / 2477

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */

package week9.SearchforaRange;

public class Solution {
	public int[] searchRange(int[] A, int target) {
		int res[] = new int[]{-1, -1};
		if(A == null || A.length == 0) return res;
		int pos = binarySearch(A, target);
		if(pos != -1){
			int s, e, m;
			
			s = 0;
			e = pos;
			while(s <= e){
				m = (s + e) / 2;
				if(A[m] == target) e = m - 1;
				else s = m + 1;
			}
			res[0] = s;
			
			s = pos;
			e = A.length - 1;
			while(s <= e){
				m = (s + e) / 2;
				if(A[m] == target) s = m + 1;
				else e = m - 1;
			}
			res[1] = e;
		}
		return res;
	}
	
	public int binarySearch(int[] A, int target){
		int s = 0, e = A.length - 1, m;
		while(s <= e){
			m = (s + e) / 2;
			if(A[m] == target) return m;
			else if(A[m] < target) s = m+1;
			else e = m-1;
		}
		return -1;
	}
}
