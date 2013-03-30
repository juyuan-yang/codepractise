package largestRecInHistogram;

import java.util.Stack;
/**
 * From leetcode online judgement
 * Problem:
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * Finished on 3/28/2013
 * @author jielu
 */
public class Solution {
	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int area = 0, i = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(i <= height.length){
			if(stack.isEmpty() || (i < height.length && height[i] >= height[stack.peek()])){
				stack.push(i++);
			}else{
				int top = stack.pop();
				area = Math.max(area, height[top] * (stack.isEmpty() ? i : i - stack.peek() -1));
			}
		}
		
		return area;

	}

}