/*
 * Add Binary - Apr 2 '12
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */

package week6.AddBinary;

public class Solution {
    public String addBinary(String a, String b) {
        if(a == null) return b;
        if(b == null) return a;
        int l1 = a.length() - 1, l2 = b.length() - 1, carry = 0;
        String res = "";
        
        while(l1 >= 0 || l2 >= 0){
            char ch1 = (l1 >= 0) ? a.charAt(l1--) : '0';
            char ch2 = (l2 >= 0) ? b.charAt(l2--) : '0';
            char ch3;
            if(ch1 == '0' && ch2 == '0'){
                ch3 = (carry == 0) ? '0' : '1';
                carry = 0;
            } else if(ch1 == '1' && ch2 == '1'){
                ch3 = (carry == 0) ? '0' : '1';
                carry = 1;
            } else {
                ch3 = (carry == 0) ? '1' : '0';
                carry = (carry == 0) ? 0 : 1;
            }
            res = ch3 + res;
        }
        if(carry == 1) return "1" + res;
        else return res;
    }
}
