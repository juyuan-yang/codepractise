/*
 * Divide Two Integers - Feb 18 '12 - 491 / 1899

Divide two integers without using multiplication, division and mod operator. 
 */

package DivideTwoIntegers;

import java.util.Stack;

public class Solution { 
	// Memory Limit Exceeded?
	public int divide(int dividend, int divisor) {
		if(divisor > dividend) return 0;
		Stack<Integer> mulN = new Stack<Integer>();
		Stack<Integer> mul2 = new Stack<Integer>();
		int temp = divisor, exp = 1, ans = 0;
		
		mulN.add(temp);
		mul2.add(exp);
		while(temp <= dividend / 2){
			temp += temp;
			exp += exp;
			mulN.add(temp);
			mul2.add(exp);	
		}
		
		while(!mulN.isEmpty()){
			if(dividend >= mulN.peek()){
				ans += mul2.peek();
				dividend -= mulN.peek();
			}
			mulN.pop();
			mul2.pop();
		}
		
		return ans;
	}
}
