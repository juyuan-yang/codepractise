/*
 * Jump Game II - Mar 17 '12 - 674 / 1953

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.) 
 */

package week7.JumpGame2;

public class Solution {
	// An amazing solution!
	public int jump(int[] A) {
		if(A == null || A.length < 2) return 0;
		int low = 0, high = 0, max, step = 0;
		
		while(low <= high){
			max = low;
			step++;
			for(int i = low; i <= high && i < A.length; i++){
				if(i + A[i] > max) max = i + A[i];
				if(max >= A.length - 1) return step;
			}
			low = high + 1;
			high = max;
		}
		return 0;
	}
}
