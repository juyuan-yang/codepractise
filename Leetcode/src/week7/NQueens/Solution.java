/*
 * N-Queens - Mar 20 '12 - 223 / 717

The n-queens puzzle is the problem of placing n queens on an n*n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' 
both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

 */

package week7.NQueens;

import java.util.ArrayList;

public class Solution {
	boolean[] col;
	boolean[] xiel, xier;
	int[] pos;
	ArrayList<String[]> res;
	int n;
	public ArrayList<String[]> solveNQueens(int n) {
		this.n = n;
		res = new ArrayList<String[]>();
		col = new boolean[n];
		xiel = new boolean[n * 2];
		xier = new boolean[n * 2];
		pos = new int[n];
		visit(0);
		return res;
	}
	
	public void visit(int cur){
		if(cur == n){
			String[] item = new String[n];
			for(int i = 0; i < n; i++){
				item[i] = "";
				for(int j = 0; j < n; j++){
					if(j == pos[i]) item[i] += "Q";
					else item[i] += ".";
				}
			}
			res.add(item);
			return;
		}
		for(int i = 0; i < n; i++){
			if(!col[i] && !xiel[cur + i] && !xier[cur - i + n]){
				pos[cur] = i;
				col[i] = true;
				xiel[cur + i] = true;
				xier[cur - i + n] = true;
				visit(cur+1);
				col[i] = false;
				xiel[cur + i] = false;
				xier[cur - i + n] = false;
			}
		}
	}
}
