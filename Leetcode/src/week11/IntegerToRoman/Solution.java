/*
Integer to Roman - Jan 15 '12 - 1476 / 3526
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 */

package week11.IntegerToRoman;

/**
 * Created with IntelliJ IDEA.
 * User: juyuan.yang
 * Date: 5/28/13
 * Time: 10:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    // I - 1, V - 5, X - 10,
    // L -50, C-100, D -500,
    // M - 1000
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int bit;
        if(num > 999){
            bit = num / 1000;
            sb.append(bitToRoman(bit, "M", "", ""));
            num %= 1000;
        }
        if(num > 99){
            bit = num / 100;
            sb.append(bitToRoman(bit, "C", "D", "M"));
            num %= 100;
        }
        if(num > 9){
            bit = num / 10;
            sb.append(bitToRoman(bit, "X", "L", "C"));
            num %= 10;
        }
        sb.append(bitToRoman(num, "I", "V", "X"));
        return sb.toString();
    }

    public String bitToRoman(int num, String ch1, String ch2, String ch3){
        switch (num) {
            case 9:
                return ch1 + ch3;
            case 8:
                return ch2 + ch1 + ch1 + ch1;
            case 7:
                return ch2 + ch1 + ch1;
            case 6:
                return ch2 + ch1;
            case 5:
                return ch2;
            case 4:
                return ch1 + ch2;
            case 3:
                return ch1 + ch1 + ch1;
            case 2:
                return ch1 + ch1;
            case 1:
                return ch1;
            case 0:
                return "";
            default:
                return "";
        }
    }
}
