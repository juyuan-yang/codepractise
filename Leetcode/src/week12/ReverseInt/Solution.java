/*
Reverse Integer - Dec 26 '11 - 4280 / 7712
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer,
then the reverse of 1000000003 overflows. How should you handle such cases?

Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function
(ie, add an extra parameter).
 */

package week12.ReverseInt;

public class Solution {
    // I just thought about overflow
    // but should know about zero problem
    public int reverse(int x) {
        return reverseMul(x, 0);
    }

    public int reverseMul(int orig, int res){
        if(orig == 0) return res;
        return reverseMul(orig / 10, res * 10 + orig % 10);
    }
}
