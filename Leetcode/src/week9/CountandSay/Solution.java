/*
 * Count and Say - Mar 6 '12 - 806 / 2074

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */

package week9.CountandSay;

public class Solution {
    public String countAndSay(int n) {
        if(n == 0) return "";
        String base = "1", say;
        for(int t = 1; t < n; t++){
            int pos = -1;
            say = "";
            for(int i = 0; i < base.length(); i++){
                if(pos == -1) pos = i;
                else if(base.charAt(i) != base.charAt(pos)){
                    say += (i - pos);
                    say += base.charAt(pos);
                    pos = i;
                }
            }
            if(pos != -1){
                say += (base.length() - pos);
                say += base.charAt(pos);
            }
            base = say;
        }
        return base;
    }
}
