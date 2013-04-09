/*
 * Valid Parentheses - Jan 30 '12 - 564 / 1442
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

package ValidParentheses;

import java.util.Stack;

public class Solution {
	// I could not do it bug free at the first time >.<
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(stack.isEmpty() || stack.pop() != '(') return false;
            } else if(s.charAt(i) == ']'){
                if(stack.isEmpty() || stack.pop() != '[') return false;
            } else if(s.charAt(i) == '}'){
                if(stack.isEmpty() || stack.pop() != '{') return false;
            } else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
