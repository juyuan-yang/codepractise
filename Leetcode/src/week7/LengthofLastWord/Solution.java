/*
 * Length of Last Word - Mar 27 '12 - 267 / 637
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
 */

package week7.LengthofLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        
        int ans = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) != ' ') ans++;
            else return ans;
        }
        return ans;
    }
}
