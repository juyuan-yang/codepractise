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
	String s1, s2;
	boolean res;
	public boolean isMatch(String s, String p) {
		if(s == null || p == null) return false;
		res = false;
		s1 = s;
		s2 = p;
		visit(0, 0);
		return res;
	}
	
	public void visit(int pos1, int pos2){
		if(res) return;
		if(pos1 == s1.length() && pos2 == s2.length()){
			res = true;
			return;
		} else if(pos1 == s1.length()){
			for(int i = pos2; i < s2.length(); i++)
				if(s2.charAt(i) != '*') return;
			res = true;
			return;
		} else if(pos2 == s2.length()){
			for(int i = pos1; i < s1.length(); i++)
				if(s1.charAt(i) != '*') return;
			res = true;
			return;
		}
		char ch1 = s1.charAt(pos1), ch2 = s2.charAt(pos2);
		if(ch1 == '*'){
			if(ch2 == '*'){
				visit(pos1, pos2 + 1);
			}
			visit(pos1 + 1, pos2);
			visit(pos1 + 1, pos2 + 1);
		} else if(ch1 == '?'){
			if(ch2 == '*'){
				visit(pos1, pos2 + 1);
			} 
			visit(pos1 + 1, pos2 + 1);
		} else {
			if(ch2 == '*'){
				visit(pos1, pos2 + 1);
				visit(pos1 + 1, pos2 + 1);
			} else if(ch2 == '?'){
				visit(pos1 + 1, pos2 + 1);
			} else if(ch1 == ch2){
				visit(pos1 + 1, pos2 + 1);
			}
		}
	}
	// memory limit exceed....
//	public boolean isMatch(String s, String p) {
//		if(s == null || p == null) return false;
//		int l1 = s.length(), l2 = p.length(), t;
//		boolean[][] res = new boolean[l1+1][l2+1];
//		
//		res[0][0] = true;
//		for(int i = 1; i <= l1; i++) res[i][0] = (s.charAt(i-1) == '*') && res[i-1][0];
//		for(int j = 1; j <= l2; j++) res[0][j] = (p.charAt(j-1) == '*') && res[0][j-1];
//		
//		for(int i = 0; i < l1; i++)
//			for(int j = 0; j < l2; j++){
//				char ch1 = s.charAt(i), ch2 = p.charAt(j);
//				
//				if(ch1 == '?'){
//					if(ch2 == '?'){
//						res[i+1][j+1] = res[i][j];
//					} else if(ch2 == '*'){
//						for(t = i+1; t >= 0; t--)
//							if(res[t][j]) {
//								res[i+1][j+1] = true;
//								break;
//							}
//						if(t < 0) res[i+1][j+1] = false;
//					} else {
//						res[i+1][j+1] = res[i][j];
//					}
//				} else if(ch1 == '*'){
//					if(ch2 == '?'){
//						for(t = j+1; t >= 0; t--)
//							if(res[i][t]) {
//								res[i+1][j+1] = true;
//								break;
//							}
//						if(t < 0){
//							for(t = i+1; t >= 0; t--)
//								if(res[t][j]) {
//									res[i+1][j+1] = true;
//									break;
//								}
//							if(t < 0) res[i+1][j+1] = false;
//						}
//					} else if(ch2 == '*'){
//						for(t = j+1; t >= 0; t--)
//							if(res[i][t]){
//								res[i+1][j+1] = true;
//								break;
//							}
//						if(t < 0) res[i+1][j+1] = false;
//					} else {
//						for(t = j+1; t >= 0; t--)
//							if(res[i][t]){
//								res[i+1][j+1] = true;
//								break;
//							}
//						if(t < 0) res[i+1][j+1] = false;
//					}
//				} else {
//					if(ch2 == '?'){
//						res[i+1][j+1] = res[i][j];
//					} else if(ch2 == '*'){
//						for(t = i+1; t >= 0; t--)
//							if(res[t][j]){
//								res[i+1][j+1] = true;
//								break;
//							}
//						if(t < 0) res[i+1][j+1] = false;
//					} else {
//						res[i+1][j+1] = res[i][j] && (ch1 == ch2);
//					}
//				}
//			}
//		return res[l1][l2];
//	}
}
