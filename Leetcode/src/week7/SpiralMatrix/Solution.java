/*
 * Spiral Matrix - Mar 25 '12 - 256 / 933

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5]. 
 */

package week7.SpiralMatrix;

import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(matrix != null && matrix.length > 0){
			int m = matrix.length, n = matrix[0].length, total = m * n;
			boolean used[][] = new boolean[m][n];
			int[] x = new int[]{0, 1, 0, -1}, y = new int[]{1, 0, -1, 0};
			int s = 0, t = 0, currentX = 0, currentY = 0;
			
			for(int i = 0; i < total; i++){
				res.add(matrix[s][t]);
				used[s][t] = true;
				if(i == total - 1) break;
				while(!(s + x[currentX] >= 0 && s + x[currentX] < m && t + y[currentY] >= 0
						&& t + y[currentY] < n && !used[s + x[currentX]][t + y[currentY]])){
					currentX = (currentX == 3) ? 0 : currentX + 1;
					currentY = (currentY == 3) ? 0 : currentY + 1;
				}
				s = s + x[currentX];
				t = t + y[currentY];
			}
		}
		return res;
	}
}
