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

public class Solution {
    public boolean isPalindrome(int x) {
        putInStack(x, x);
        return false;
    }

    public int putInStack(int x1, int x2){
        if(x1 > 0){
            int num = putInStack(x1 / 10, x2);
            if(x2 % 10 == )
        } else
            return x2;
    }
}
