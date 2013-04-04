/*
 * Plus One - Apr 2 '12
Given a number represented as an array of digits, plus one to the number.
 */

package week6.PlusOne;

public class Solution {
    public int[] plusOne(int[] digits) {        
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            if(carry == 0) break;
            carry = (digits[i] == 9) ? 1 : 0;
            digits[i] = (digits[i] == 9) ? 0 : digits[i] + 1;
        }
        if(carry == 1){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
