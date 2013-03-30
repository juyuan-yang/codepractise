/*
 * Search a 2D Matrix - Apr 7 '12

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

Given target = 3, return true.
 */

package week6.Searcha2DMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m-1][n-1]) return false;
        
        int s = 0, t = m - 1, mi, line;
        while(s <= t){
        	mi = s + (t - s) / 2;
        	if(matrix[mi][0] == target) return true;
	        else if(matrix[mi][0] < target) s = mi+1;
	        else t = mi-1;
        }
        line = t; // it's interesting here to use t
        s = 0;
        t = n - 1;
        while(s <= t){
        	mi = s + (t - s) / 2;
        	if(matrix[line][mi] == target) return true;
        	else if(matrix[line][mi] < target) s = mi+1;
        	else t = mi-1;
        }
        // Lazy way ^_^
//        for(int i = 0; i < m; i++){
//            if(target == matrix[i][0]) return true;
//            else if(target > matrix[i][0] && (i == m-1 || target < matrix[i+1][0])){
//                int s = 0, t = n-1, mi;
//                while(s <= t){
//                    mi = s + (t - s) / 2;
//                    if(matrix[i][mi] == target) return true;
//                    else if(matrix[i][mi] < target) s = mi+1;
//                    else t = mi-1;
//                }
//            }
//        }
        return false;
    }
}
