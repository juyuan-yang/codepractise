/*
 * Valid Sudoku - Mar 3 '12 - 479 / 1879

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules. http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.
 */

package week9.ValidSudoku;

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		for(int i = 0; i < 9; i++){
			if(!checkCol(board, i)) return false;
			if(!checkRow(board, i)) return false;
		}
		int[] x = {1, 4, 7}, y = {1, 4, 7};
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++){
				if(!checkZone(board, x[i], y[j])) return false;
			}
		return true;
	}
	
	public boolean checkZone(char[][] board, int centerX, int centerY){
		int bit = 0;
		int[] x = {-1, 0, 1}, y = {-1, 0, 1};
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++){
				if(board[centerX + x[i]][centerY + y[j]] == '.') continue;
				if(((1 << (board[centerX + x[i]][centerY + y[j]] - '0')) & bit) > 0) return false;
				bit |= 1 <<(board[centerX + x[i]][centerY + y[j]] - '0');
			}
		
		return true;
	}
	
	public boolean checkCol(char[][] board, int col){
		int bit = 0;
		for(int i = 0; i < 9; i++){
			if(board[i][col] == '.') continue;
			if(((1 << (board[i][col] - '0')) & bit) > 0) return false;
			bit |= 1 << (board[i][col] - '0');
		}
		return true;
	}
	
	public boolean checkRow(char[][] board, int row){
		int bit = 0;
		for(int i = 0; i < 9; i++){
			if(board[row][i] == '.') continue;
			if(((1 << (board[row][i] - '0')) & bit) > 0) return false;
			bit |= 1 << (board[row][i] - '0');
		}
		return true;
	}
}
