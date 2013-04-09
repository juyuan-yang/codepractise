/*
 * Letter Combinations of a Phone Number - Jan 27 '12 - 402 / 1084
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

package LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;

public class Solution {
	// code looks like a shit again...
    ArrayList<String> res;
    char[] ans;
    String digits;
    public ArrayList<String> letterCombinations(String digits) {
        res = new ArrayList<String>();
        this.digits = digits;
        if(digits != null && digits.length() > 0){
            ans = new char[digits.length()];
            visit(0);
        } else res.add("");
        return res;
    }
    
    public void visit(int cur){
        if(cur == digits.length()){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < digits.length(); i++){
                if(ans[i] != '0') sb.append(ans[i]);
            }
            res.add(sb.toString());
            return;
        }
        char ch = digits.charAt(cur);
        if(ch == '1') {
            ans[cur] = '0';
        } else if(ch <= '6'){
            for(int i = 0; i < 3; i++){
                ans[cur] = (char) ('a' + (ch - '2') * 3 + i);
                visit(cur + 1);
            }
        } else if(ch == '7'){
            for(int i = 0; i < 4; i++){
                ans[cur] = (char) ('a' + (ch - '2') * 3 + i);
                visit(cur + 1);
            }
        } else if(ch == '8'){
            for(int i = 0; i < 3; i++){
                ans[cur] = (char) ('a' + 1 + (ch - '2') * 3 + i);
                visit(cur + 1);
            }
        } else if(ch == '9'){
            for(int i = 0; i < 4; i++){
                ans[cur] = (char) ('a' + 1 + (ch - '2') * 3 + i);
                visit(cur + 1);
            }
        } else if(ch == '0'){
            ans[cur] = ' ';
            visit(cur + 1);
        }
    }
}
