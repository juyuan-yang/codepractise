/*
Roman to Integer - Jan 15 '12 - 1467 / 2990
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */

package week11.RomanToInteger;

/**
 * Created with IntelliJ IDEA.
 * User: juyuan.yang
 * Date: 5/28/13
 * Time: 11:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    // I - 1, V - 5, X - 10,
    // L -50, C-100, D -500,
    // M - 1000
    public int romanToInt(String s) {
        int res = 0;
        if(s == null) return res;
        for(int i = 0; i < s.length(); i++){
            if(i + 1 < s.length() && getInt(s.charAt(i)) < getInt(s.charAt(i+1))){
                res += getInt(s.charAt(i+1)) - getInt(s.charAt(i));
                i++;
            } else {
                res += getInt(s.charAt(i));
            }
        }
        return res;
    }

    public int getInt(char ch){
        switch (ch){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
