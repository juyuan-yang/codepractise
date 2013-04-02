/*
 * Minimum Window Substring - Apr 15 '12
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */

package week6.MinimumWindowSubstring;

public class Solution {
    public String minWindow(String S, String T) {
        int min = 10000, max = 0;
        for(int i = 0; i < S.length(); i++) {
        	if(S.charAt(i) < min) min = S.charAt(i);
        	if(S.charAt(i) > max) max = S.charAt(i);
        }
        for(int i = 0; i < T.length(); i++) {
        	if(T.charAt(i) < min) min = T.charAt(i);
        	if(T.charAt(i) > max) max = T.charAt(i);
        }
        if(max < min) return "";
        int[] s = new int[max - min + 1];
        int[] t = new int[max - min + 1];
        int uniqCh = 0;
        for(int i = 0; i < T.length(); i++){
        	if(t[T.charAt(i) - min] == 0) uniqCh++;
        	t[T.charAt(i) - min]++;
        }
        
        int cur = -1, index, got = 0, start = -1, end = -1;
        for(int i = 0; i < S.length(); i++){
        	index = S.charAt(i) - min;
        	if(t[index] > 0){ // this char appears in T
        		if(cur == -1) cur = i; // the start of window
        		s[index]++;
        		if(s[index] == t[index]){ // has enough this char
        			got++;
        			if(got == uniqCh){ // find one window
        				if(start == -1 || end - start > i - cur){
        					start = cur;
        					end = i;
        				}
        			}
        		}
        		if(got == uniqCh){ // already has window, try to update it
        			while(t[S.charAt(cur) - min] == 0 || 
        					s[S.charAt(cur) - min] > t[S.charAt(cur) - min]) { 
        				s[S.charAt(cur) - min]--;
        				cur++;
        			}
        			if(end - start > i - cur){
    					start = cur;
    					end = i;
    				}
        		}
        	}
        }
        return (start == -1) ? "" : S.substring(start, end+1);
    }
}
