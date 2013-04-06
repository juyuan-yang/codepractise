/*
 * Maximum Subarray - Mar 21 '12 - 336 / 660
Find the contiguous subarray within an array (containing at least one number) 
which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

More practice:
If you have figured out the O(n) solution, try coding another solution using 
the divide and conquer approach, which is more subtle.
 */

package week7.MaximumSubarray;

public class Solution {
	public int maxSubArray(int[] A) {
		if(A == null || A.length == 0) return 0;
		if(A.length == 1) return A[0];
		int[] res = new int[A.length];
		int max = A[0];
		
		for(int i = 0; i < A.length; i++){
			res[i] = A[i];
			if(A[i] > max) max = A[i];
		}
		for(int i = 1; i < A.length; i++){
			for(int j = A.length - i - 1; j >= 0; j--){
				res[j+i] = res[j+i-1] + A[j+i];
				if(res[j+i] > max) max = res[j+i];
			}
		}
		return max;
	}
}
