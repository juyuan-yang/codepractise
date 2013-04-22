/*
 * Longest Valid Parentheses - Mar 1 '12 - 964 / 3316

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

package week9.LongestValidParentheses;

import java.util.Stack;

public class Solution {
	String s;
	public int longestValidParentheses(String s) {
		if(s == null || s.length() == 0) return 0;
		this.s = s;
		int max = 0, pos, length = 0, preend = -1;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '('){
				pos = getValid(i, '(', ')', true);
				if(pos != -1){
					if(preend + 1 == i) length += pos - i + 1;
					else length = pos - i + 1;
					if(length > max) max = length;
					i = pos;
					preend = pos;
				} else break;
			}
		}
		preend = s.length();
		length = 0;
		for(int i = s.length() - 1; i >= 0; i--){
			if(s.charAt(i) == ')'){
				pos = getValid(i, ')', '(', false);
				if(pos != -1){
					if(i + 1 == preend) length += i - pos + 1;
					else length = i - pos + 1;
					if(length > max) max = length;
					i = pos;
					preend = pos;
				} else break;
			}
		}
		return max;
	}
	
	public int getValid(int start, char ch1, char ch2, boolean increaz){
		Stack<Integer> stack = new Stack<Integer>();
		while(start < s.length() && start >= 0){
			if(s.charAt(start) == ch1) stack.push(start);
			else if(s.charAt(start) == ch2){
				if(stack.size() > 0) stack.pop();
				else return -1;
			}
			if(stack.size() == 0) return start;
			if(increaz) start ++;
			else start --;
		}
		return -1;
	}
}
