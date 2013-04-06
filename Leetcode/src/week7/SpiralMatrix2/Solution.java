/*
 * Spiral Matrix II - Mar 28 '12 - 176 / 452

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,
You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 */

package week7.SpiralMatrix2;

public class Solution {
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		
		int total = n * n;
		boolean used[][] = new boolean[n][n];
		int[] x = new int[]{0, 1, 0, -1}, y = new int[]{1, 0, -1, 0};
		int s = 0, t = 0, currentX = 0, currentY = 0;
		
		for(int i = 1; i <= total; i++){
			res[s][t] = i;
			used[s][t] = true;
			if(i == total) break;
			while(!(s + x[currentX] >= 0 && s + x[currentX] < n && t + y[currentY] >= 0
					&& t + y[currentY] < n && !used[s + x[currentX]][t + y[currentY]])){
				currentX = (currentX == 3) ? 0 : currentX + 1;
				currentY = (currentY == 3) ? 0 : currentY + 1;
			}
			s = s + x[currentX];
			t = t + y[currentY];
		}
		
		return res;
	}
}
