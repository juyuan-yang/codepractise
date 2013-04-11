/*
 * Wildcard Matching - Mar 16 '12 - 574 / 2416
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ? false
isMatch("aa","aa") ? true
isMatch("aaa","aa") ? false
isMatch("aa", "*") ? true
isMatch("aa", "a*") ? true
isMatch("ab", "?*") ? true
isMatch("aab", "c*a*b") ? false
 */

package week7.WildcardMatching;

public class Solution {
	// memory limit exceed....
	public boolean isMatch(String s, String p) {
		if(s == null || p == null) return false;
		int l1 = s.length(), l2 = p.length(), t;
		boolean[][] res = new boolean[l1+1][l2+1];
		
		res[0][0] = true;
		for(int i = 1; i <= l1; i++) res[i][0] = (s.charAt(i-1) == '*') && res[i-1][0];
		for(int j = 1; j <= l2; j++) res[0][j] = (p.charAt(j-1) == '*') && res[0][j-1];
		
		for(int i = 0; i < l1; i++)
			for(int j = 0; j < l2; j++){
				char ch1 = s.charAt(i), ch2 = p.charAt(j);
				
				if(ch1 == '?'){
					if(ch2 == '?'){
						res[i+1][j+1] = res[i][j];
					} else if(ch2 == '*'){
						for(t = i+1; t >= 0; t--)
							if(res[t][j]) {
								res[i+1][j+1] = true;
								break;
							}
						if(t < 0) res[i+1][j+1] = false;
					} else {
						res[i+1][j+1] = res[i][j];
					}
				} else if(ch1 == '*'){
					if(ch2 == '?'){
						for(t = j+1; t >= 0; t--)
							if(res[i][t]) {
								res[i+1][j+1] = true;
								break;
							}
						if(t < 0){
							for(t = i+1; t >= 0; t--)
								if(res[t][j]) {
									res[i+1][j+1] = true;
									break;
								}
							if(t < 0) res[i+1][j+1] = false;
						}
					} else if(ch2 == '*'){
						for(t = j+1; t >= 0; t--)
							if(res[i][t]){
								res[i+1][j+1] = true;
								break;
							}
						if(t < 0) res[i+1][j+1] = false;
					} else {
						for(t = j+1; t >= 0; t--)
							if(res[i][t]){
								res[i+1][j+1] = true;
								break;
							}
						if(t < 0) res[i+1][j+1] = false;
					}
				} else {
					if(ch2 == '?'){
						res[i+1][j+1] = res[i][j];
					} else if(ch2 == '*'){
						for(t = i+1; t >= 0; t--)
							if(res[t][j]){
								res[i+1][j+1] = true;
								break;
							}
						if(t < 0) res[i+1][j+1] = false;
					} else {
						res[i+1][j+1] = res[i][j] && (ch1 == ch2);
					}
				}
			}
		return res[l1][l2];
	}
}
