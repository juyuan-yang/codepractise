/*
 * Word Search - Apr 18 '12

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */

package week6.WordSearch;

public class Solution {
    char[][] board;
    boolean[][] visit;
    String word;
    boolean res;
    int m, n;
    
    // Time Limit Exceeded?
    public boolean exist(char[][] board, String word) {
        res = false;
        this.word = word;
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.visit = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    visit[i][j] = true;
                    visit(i, j, 1);
                    visit[i][j] = false;
                }
            }
        }
        return res;
    }
    
    public void visit(int s, int t, int pos){
        if(res) return;
        if(pos == word.length()){
            res = true;
            return;
        }
        if(s > 0){
            if(!visit[s-1][t] && board[s-1][t] == word.charAt(pos)){
                visit[s-1][t] = true;
                visit(s-1, t, pos+1);
                visit[s-1][t] = false;
            }
        }
        if(s < m - 1){
            if(!visit[s+1][t] && board[s+1][t] == word.charAt(pos)){
                visit[s+1][t] = true;
                visit(s+1, t, pos+1);
                visit[s+1][t] = false;
            }
        }
        if(t > 0){
            if(!visit[s][t-1] && board[s][t-1] == word.charAt(pos)){
                visit[s][t-1] = true;
                visit(s, t-1, pos+1);
                visit[s][t-1] = false;
            }
        }
        if(t < n - 1){
            if(!visit[s][t+1] && board[s][t+1] == word.charAt(pos)){
                visit[s][t+1] = true;
                visit(s, t+1, pos+1);
                visit[s][t+1] = false;
            }
        }
    }
}
