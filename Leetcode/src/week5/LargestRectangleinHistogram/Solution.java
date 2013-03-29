/*
 * Largest Rectangle in Histogram - Apr 23 '12
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
 */

package week5.LargestRectangleinHistogram;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] height) {
        int max = 0, i = 0;
        Stack<Integer> pre = new Stack<Integer>();
        
        while(i <= height.length){
            if(pre.isEmpty() || (i < height.length && height[i] >= height[pre.peek()])){
        		pre.push(i++);
        	} else {
        		int t = pre.pop();
        		max = getMax(max, height[t] * ((pre.isEmpty()) ? i : (i - 1 - pre.peek())));
        	}
        }
        return max;
    }
    
    public int getMax(int num1, int num2){
    	return (num1 > num2) ? num1 : num2;
    }
}
