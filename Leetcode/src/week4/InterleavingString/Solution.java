/*
 * Interleaving String - Aug 31 '12

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false. 
 */

package week4.InterleavingString;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Time limit exceed
    String s1, s2, s3;
    boolean res;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.res = false;
        int b1 = 0, b2 = 0, e1 = s1.length(), e2 = s2.length();
        if(e1 + e2 != s3.length()) return false;
        visit(b1, e1, b2, e2);
        return res;
    }
    
    public void visit(int b1, int e1, int b2, int e2){
        if(b1 == e1 && b2 == e2){
    		this.res = true;
    		return;
    	}
        if(this.res) return;
        int b3 = b1 + b2;
    	char ch1 = (b1 < e1) ? s1.charAt(b1) : '*';
    	char ch2 = (b2 < e2) ? s2.charAt(b2) : '*';
        char ch = s3.charAt(b3);
        if(ch == ch1 && ch == ch2){
        	visit(b1+1, e1, b2, e2);
        	visit(b1, e1, b2+1, e2);
        } else if(ch == ch1 && ch != ch2){
        	visit(b1+1, e1, b2, e2);
        } else if(ch != ch1 && ch == ch2){
        	visit(b1, e1, b2+1, e2);
        }
    }
}
