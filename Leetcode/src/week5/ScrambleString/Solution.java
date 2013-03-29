/*
 * Scramble String - Apr 30 '12
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty 
substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string 
"rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled 
string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */

package week5.ScrambleString;

// The code may look like a shit... Any new idea?
public class Solution {
	String s1, s2;

    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null) return true;
        if(s1.length() != s2.length()) return false;
    	this.s1 = s1;
    	this.s2 = s2;
    	return visit(0, s1.length(), 0, s2.length());
    }
    
    public boolean visit(int b1, int t1, int b2, int t2){
    	if(b1 + 1 == t1) return s1.charAt(b1) == s2.charAt(b2);
    	if(b1 >= t1) return true;
    	
    	int[] visit = new int[26];
    	int not0count = 0;
    	boolean res = false;
    	
    	for(int i = 0; i < t1 - b1 - 1; i++){
    		if(visit[s1.charAt(b1 + i) - 'a'] == 0) not0count++;
    		else if(visit[s1.charAt(b1 + i) - 'a'] == -1) not0count--;
    		visit[s1.charAt(b1 + i) - 'a']++;
    		if(visit[s2.charAt(b2 + i) - 'a'] == 0)	not0count++;
    		else if(visit[s2.charAt(b2 + i) - 'a'] == 1) not0count--;
    		visit[s2.charAt(b2 + i) - 'a']--;
    		if(not0count == 0){
    			res = visit(b1, b1 + i + 1, b2, b2 + i + 1)
    					&& visit(b1 + i + 1, t1, b2 + i + 1, t2);
    			break;
    		}
    	}
    	
    	if(res) return true;
    	for(int i = 0; i < 26; i++) visit[i] = 0;
    	not0count = 0;
    	for(int i = 0; i < t1 - b1 - 1; i++){
    		if(visit[s1.charAt(t1 - i - 1) - 'a'] == 0) not0count++;
    		else if(visit[s1.charAt(t1 - i - 1) - 'a'] == -1) not0count--;
    		visit[s1.charAt(t1 - i - 1) - 'a']++;
    		if(visit[s2.charAt(b2 + i) - 'a'] == 0)	not0count++;
    		else if(visit[s2.charAt(b2 + i) - 'a'] == 1) not0count--;
    		visit[s2.charAt(b2 + i) - 'a']--;
    		if(not0count == 0){
    			res = visit(t1 - i - 1, t1, b2, b2 + i + 1)
    					&& visit(b1, t1 - i - 1, b2 + i + 1, t1);
    			break;
    		}
    	}
    	return res;
    }
}
