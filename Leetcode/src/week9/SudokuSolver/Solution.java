/*
 * Sudoku Solver - Mar 4 '12 - 420 / 1444
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.



A sudoku puzzle...



...and its solution numbers marked in red.
 */

package week9.SudokuSolver;

public class Solution {
	char[][] board;
	boolean[][] rows, cols, zones;
	boolean found;
	
	public void solveSudoku(char[][] board) {
		this.board = board;
		this.rows = new boolean[9][9];
		this.cols = new boolean[9][9];
		this.zones = new boolean[9][9];
		this.found = false;
		init();
		visit(0, 0);
		board = this.board;
	}
	
	public void visit(int s, int t){
		if(found) return;
		while(t == 9 || board[s][t] != '.'){
			t++;
			if(t >= 9){
				t = 0;
				s++;
				if(s == 9){
					found = true;
					return;
				}
			}
		}
		
		for(int i = 0; i < 9; i++){
			if(!rows[s][i] && !cols[t][i] && !zones[zoneMap(s, t)][i]){
				board[s][t] = (char) ('1' + i);
				rows[s][i] = true;
				cols[t][i] = true;
				zones[zoneMap(s, t)][i] = true;
				visit(s, t+1);
				if(found) return;
				board[s][t] = '.';
				rows[s][i] = false;
				cols[t][i] = false;
				zones[zoneMap(s, t)][i] = false;
			}
		}
	}
	
	public void init(){
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++){
				if(board[i][j] != '.'){
					int temp = board[i][j] - '1';
					rows[i][temp] = true;
					cols[j][temp] = true;
					zones[zoneMap(i, j)][temp] = true;
				}
			}
	}
	
	public int zoneMap(int i, int j){
		return (i / 3) * 3 + j / 3;
	}
}
