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
 * References for optimized solution: 
 * http://fisherlei.blogspot.com/2012/12/leetcode-largest-rectangle-in-histogram.html
 * http://www.informatik.uni-ulm.de/acm/Locals/2003/html/judge.html
 *
 */
public class Solution {
    public static int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int length = height.length;
        if(height == null || length == 0)
        	return 0;

        if(length == 1)
        	return height[0];


        int area = Integer.MIN_VALUE;
        Stack<Integer> heights = new Stack<Integer>(); /* Heights that are not merged*/
        Stack<Integer> distances = new Stack<Integer>(); /* Distance from the current height to next available height*/

        heights.push(height[0]);
        distances.push(1);

        for(int i=1; i<=length; i++){
        	int curHeight = -1;
        	if(i < length) curHeight = height[i];

        	if(curHeight >= heights.peek()){
        		heights.push(curHeight);
        		distances.push(1);
        	}else{
        		int distance = 0;
        		int minHeight = Integer.MAX_VALUE;
        		
        		while(!heights.isEmpty() && heights.peek() >= curHeight){
        			int top = heights.pop();
        			minHeight = Math.min(minHeight, top);
        			distance += distances.pop();
        			area = Math.max(area, minHeight * distance);
        		}

        		heights.push(curHeight);
        		distances.push(distance + 1);
        	}
        }

        return area;       
    }
}