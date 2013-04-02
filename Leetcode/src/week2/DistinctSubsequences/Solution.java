/*
 * Distinct Subsequences - Oct 19 '12
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 */

package week2.DistinctSubsequences;

// could not believe this solution is enough to pass all the test cases = =
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int numDistinct(String S, String T) {
    	if(S == null || T == null) return 0;
        int n = S.length(), m = T.length();
        if(m == 0 || n == 0) return 0;
        int[][] res = new int[n][m];
        
        if(S.charAt(0) == T.charAt(0)) res[0][0] = 1;
        for(int j = 1; j < m; j++) res[0][j] = 0;
        for(int i = 1; i < n; i++){
        	if(S.charAt(i) == T.charAt(0)) res[i][0] = res[i-1][0] + 1;
        	else res[i][0] = res[i-1][0];
        }
        
        for(int i = 1; i < n; i++)
        	for(int j = 1; j < m; j++)
        		if(S.charAt(i) == T.charAt(j))
        			res[i][j] = res[i-1][j] + res[i-1][j-1];
        		else res[i][j] = res[i-1][j];
        
        return res[n-1][m-1];
    }
}
