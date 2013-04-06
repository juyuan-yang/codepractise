/*
 * N-Queens II - Mar 20 '12 - 238 / 531

Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.


 */

package week7.NQueens2;

public class Solution {
	boolean[] col;
	boolean[] xiel, xier;
	int[] pos;
	int res;
	int n;
	public int totalNQueens(int n) {
		this.n = n;
		res = 0;
		col = new boolean[n];
		xiel = new boolean[n * 2];
		xier = new boolean[n * 2];
		pos = new int[n];
		visit(0);
		return res;
	}
	
	public void visit(int cur){
		if(cur == n){
			res++;
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
