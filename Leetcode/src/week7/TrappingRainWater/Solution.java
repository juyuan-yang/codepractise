/*
 * Trapping Rain Water - Mar 10 '12 - 448 / 1176
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. 
Thanks Marcos for contributing this image!
 */

package week7.TrappingRainWater;

import java.util.Stack;

public class Solution {
	public int trap(int[] A) {
		if(A == null || A.length == 0) return 0;
		int res = 0, pos = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(pos < A.length){
			if(stack.isEmpty()){
				if(A[pos] > 0) stack.push(pos);
				pos++;
			} else {
				if(A[pos] < A[stack.peek()]){
					stack.push(pos++);
				} else if(A[pos] == A[stack.peek()]){
					stack.pop();
					stack.push(pos++);
				} else {
					if(stack.size() == 1){
						stack.pop();
						stack.push(pos++);
					} else {
						int bottom = A[stack.pop()];
						int length = pos - 1 - stack.peek();
						int hight = getMin(A[pos], A[stack.peek()]);
						res += (hight - bottom) * length;
					}
				}
			}
		}
		
		return res;
	}
	
	public int getMin(int num1, int num2){
		return (num1 > num2) ? num2 : num1;
	}
}
