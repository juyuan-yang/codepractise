/*
 * Surrounded Regions - Feb 22
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region .
 * 
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */

package week1.SurroundedRegions;

// one reference: http://blog.sina.com.cn/s/blog_b9285de20101j1dt.html
// Shit... I have met so many Time Limit Exceed...
public class Solution {
	char[][] board;

	public static void main(String[] args) {
		String[] strs = new String[] {"OXXOX","XOOXO","XOXOX","OXOOO","XXOXO"};
		char[][] board = new char[strs.length][strs[0].length()];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = strs[i].charAt(j);
			}
		}
//		solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public void solve(char[][] board) {
		if (board.length <= 2)
			return;
		// this.board = board;
		int m = board.length;
		int n = board[0].length;
		int[] xlist = new int[m * n];
		int[] ylist = new int[m * n];
		int start = 0, end = 0;

		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O'){
				xlist[end] = i;
				ylist[end++] = 0;
				board[i][0] = 'F';
			}
			if (board[i][n - 1] == 'O'){
				xlist[end] = i;
				ylist[end++] = n - 1;
				board[i][n - 1] = 'F';
			}
		}

		for (int j = 1; j < n - 1; j++) {
			if (board[0][j] == 'O'){
				xlist[end] = 0;
				ylist[end++] = j;
				board[0][j] = 'F';
			}
			if (board[m - 1][j] == 'O'){
				xlist[end] = m - 1;
				ylist[end++] = j;
				board[m - 1][j] = 'F';
			}
		}
		
		int s, t;
		while (start < end) {
			s = xlist[start];
			t = ylist[start];
			if (s + 1 < m && board[s + 1][t] == 'O') {
				xlist[end] = s + 1;
				ylist[end++] = t;
				board[s + 1][t] = 'F';
			}
			if (s > 0 && board[s - 1][t] == 'O') {
				xlist[end] = s - 1;
				ylist[end++] = t;
				board[s - 1][t] = 'F';
			}
			if (t + 1 < n && board[s][t + 1] == 'O') {
				xlist[end] = s;
				ylist[end++] = t + 1;
				board[s][t + 1] = 'F';
			}
			if (t > 1 && board[s][t - 1] == 'O') {
				xlist[end] = s;
				ylist[end++] = t - 1;
				board[s][t - 1] = 'F';
			}
			start++;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == 'F')
					board[i][j] = 'O';
			}
		}
	}

	public void visitNode(int s, int t, int m, int n) {
		if (s >= 0 && s < m && t >= 0 && t < n && board[s][t] == 'O') {
			board[s][t] = 'F';
		} else
			return;
		visitNode(s + 1, t, m, n);
		visitNode(s - 1, t, m, n);
		visitNode(s, t + 1, m, n);
		visitNode(s, t - 1, m, n);
	}

	public void solve1(char[][] board) {
		if (board.length <= 2)
			return;
		int m = board.length;
		int n = board[0].length;

		boolean[][] visit = new boolean[m][n];
		int[] xlist = new int[m * n];
		int[] ylist = new int[m * n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j] && board[i][j] == 'O') {
					int start = -1, end = 0;
					boolean edge = false;

					xlist[0] = i;
					ylist[0] = j;
					visit[i][j] = true;

					while (start < end) {
						start++;
						int s = xlist[start], t = ylist[start];

						if (s == m - 1 || s == 0 || t == n - 1 || t == 0) {
							edge = true;
						}
						if (s + 1 < m && !visit[s + 1][t]
								&& board[s + 1][t] == 'O') {
							xlist[++end] = s + 1;
							ylist[end] = t;
							visit[s + 1][t] = true;
						}
						if (s - 1 >= 0 && !visit[s - 1][t]
								&& board[s - 1][t] == 'O') {
							xlist[++end] = s - 1;
							ylist[end] = t;
							visit[s - 1][t] = true;
						}
						if (t + 1 < n && !visit[s][t + 1]
								&& board[s][t + 1] == 'O') {
							xlist[++end] = s;
							ylist[end] = t + 1;
							visit[s][t + 1] = true;
						}
						if (t - 1 >= 0 && !visit[s][t - 1]
								&& board[s][t - 1] == 'O') {
							xlist[++end] = s;
							ylist[end] = t - 1;
							visit[s][t - 1] = true;
						}
					}
					if (!edge) {
						for (int k = 0; k <= end; k++)
							board[xlist[k]][ylist[k]] = 'X';
					}
				}
			}
		}
	}
}
