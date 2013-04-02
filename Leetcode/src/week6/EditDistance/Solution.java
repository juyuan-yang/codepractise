/*
 * Edit Distance - Apr 4 '12
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 */

package week6.EditDistance;

public class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        
        int[][] res = new int[l1+1][l2+1];
        
        for(int i = 0; i <= l1; i++) res[i][0] = i;
        for(int j = 0; j <= l2; j++) res[0][j] = j;
        
        for(int i = 1; i <= l1; i++) {
        	for(int j = 1; j <= l2; j++){
        		res[i][j] = min(res[i-1][j] + 1, res[i][j-1] + 1);
        		if(word1.charAt(i-1) == word2.charAt(j-1))
        			res[i][j] = min(res[i][j], res[i-1][j-1]);
        		else
        			res[i][j] = min(res[i][j], res[i-1][j-1] + 1);
        	}
        }
        
        return res[l1][l2];
    }
    
    public int min(int num1, int num2){
    	return (num1 > num2) ? num2 : num1;
    }
}
