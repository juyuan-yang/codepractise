/*
 * Generate Parentheses - Feb 13 '12 - 1128 / 2694

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */

package week9.GenerateParentheses;

import java.util.ArrayList;

public class Solution {
	ArrayList<String> res;
	char[] ans;
	public ArrayList<String> generateParenthesis(int n) {
		res = new ArrayList<String>();
		ans = new char[n*2];
		visit(0, n, n);
		return res;
	}
	
	public void visit(int pos, int one, int zero){
		if(pos == ans.length){
			String s = new String(ans);
			res.add(s);
			return;
		}
		if(one > 0){
			ans[pos] = '(';
			visit(pos+1, one-1, zero);
		}
		if(zero > 0 && one < zero){
			ans[pos] = ')';
			visit(pos+1, one, zero-1);
		}
	}
}
