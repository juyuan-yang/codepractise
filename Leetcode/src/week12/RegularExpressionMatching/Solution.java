/*
Regular Expression Matching - Jan 8 '12 - 3896 / 14253
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ? false
isMatch("aa","aa") ? true
isMatch("aaa","aa") ? false
isMatch("aa", "a*") ? true
isMatch("aa", ".*") ? true
isMatch("ab", ".*") ? true
isMatch("aab", "c*a*b") ? true
 */


package week12.RegularExpressionMatching;

public class Solution {
    public boolean isMatch(String s, String p) {
        if(p == null && s == null) return true;
        else if(p == null) return false;
        else if(s == null) {
            if(p.length() == 0) return true;
            else if(p.length() == 1){ // assume p could not be "*"
                if(p.charAt(0) == '.') return true;
                else return false;
            } else if(p.length() == 2) {
                if(p.charAt(1) == '*') return true;
                else return false;
            }
        }
        return internalIsMatch(s, p, 0, 0);
    }

    public boolean internalIsMatch(String s, String p, int sIndex, int pIndex) {
        if(pIndex == p.length()) {
            return sIndex == s.length();
        }

        if(pIndex + 1 < p.length() && p.charAt(pIndex + 1) != '*') {
            if(sIndex == s.length()) return false;
            if(p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.'){
                return internalIsMatch(s, p, sIndex+1, pIndex+1);
            } else {
                return false;
            }
        } else {
            while(sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')){
                if(internalIsMatch(s, p, sIndex, pIndex+2)){
                    return true;
                }
                sIndex++;
            }
            return internalIsMatch(s, p, sIndex, pIndex+2);
        }
    }
}
