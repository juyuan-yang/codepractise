/*
 * Maximal Rectangle - Apr 24 '12 - 190 / 697
Given a 2D binary matrix filled with 0's and 1's, 
find the largest rectangle containing all ones and return its area.
 */

package week6.MaximalRectangle;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null) return 0;
        int m = matrix.length;
        if(m < 1) return 0;
        int n = matrix[0].length;
        int[] h = new int[n + 1];
        int max = 0, cur, pre;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(i == 0) h[j] = (matrix[i][j] == '1') ? 1 : 0;
        		else h[j] = (matrix[i][j] == '1') ? h[j]+1 : 0;
        	}
        	cur = 0;
        	while(cur <= n){
        		if(stack.isEmpty() || h[cur] >= h[stack.peek()]){
        			stack.push(cur++);
        		} else {
        			pre = stack.pop();
        			int temp = (cur - 1 - ((stack.isEmpty()) ? -1 : stack.peek() )) * h[pre];
        			if(temp > max) max = temp;
        		}
        	}
        	stack.clear();
        }
        return max;
    }
}
