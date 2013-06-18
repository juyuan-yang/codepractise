/*
Palindrome Number - Jan 4 '12 - 3589 / 8991
Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
 */

package week11.PalindromeNumber;

// not sure whether this is allowed
public class Solution {
    boolean res;
    public boolean isPalindrome(int x) {
        res = true;
        if(x <0){
            return false;
            //if(x == Integer.MIN_VALUE) return false;
            //else putInStack(-x, -x);
        } else
            putInStack(x, x);
        return res;
    }

    public int putInStack(int x1, int orig){
        if(x1 > 0){
            int x2 = putInStack(x1 / 10, orig);
            if(x2 % 10 != x1 % 10){
                res = false;
            }
            return x2 / 10;
        } else
            return orig;
    }
}
