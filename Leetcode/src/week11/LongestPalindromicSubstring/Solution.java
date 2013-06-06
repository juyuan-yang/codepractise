/*
Longest Palindromic Substring - Nov 11 '11 - 3064 / 10078

Given a string S, find the longest palindromic substring in S.
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */

package week11.LongestPalindromicSubstring;

/**
 * Created with IntelliJ IDEA.
 * User: juyuan.yang
 * Date: 5/30/13
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        if(s != null && s.length() > 0){
            res += s.charAt(0);
            int max = 1, t, mid = 0, length = 0;
            boolean odd = true;
            for(int i = 1; i < s.length() - 1; i++){
                t = 1;
                while(i-t >= 0 && i+t < s.length() && s.charAt(i-t) == s.charAt(i+t)) t++;
                if(t*2 - 1 > max) {
                    max = t*2 - 1;
                    mid = i;
                    length = t-1;
                }
            }
            for(int i = 0; i < s.length() - 1; i++){
                t = 1;
                while(i-t+1 >= 0 && i+t < s.length() && s.charAt(i-t+1) == s.charAt(i+t)) t++;
                if(t*2-2 > max) {
                    odd = false;
                    max = t*2 - 2;
                    mid = i;
                    length = t-1;
                }
            }
            if(odd){
                res = s.substring(mid-length, mid-length+max);
            } else {
                res = s.substring(mid-length+1, mid-length+1+max);
            }
        }
        return res;
    }
}
