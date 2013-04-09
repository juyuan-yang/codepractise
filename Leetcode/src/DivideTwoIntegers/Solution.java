/*
 * Divide Two Integers - Feb 18 '12 - 491 / 1899

Divide two integers without using multiplication, division and mod operator. 
 */

package DivideTwoIntegers;

//import java.util.Stack;

public class Solution { 
	// bit operation is amazing!
	// but how to deal with -Max_Int?
	public int divide(int dividend, int divisor) {
		if(divisor > dividend) return 0;
		boolean neg = (dividend < 0) ^ (divisor < 0);
		if(dividend < 0) dividend = -dividend;
		if(divisor < 0) divisor = -divisor;
		int temp = divisor, exp = 1, ans = 0;
		
		while(temp <= dividend / 2){
			temp = temp << 1;
			exp = exp << 1;	
		}
		
		while(exp > 0){
			if(dividend >= temp){
				ans += exp;
				dividend -= temp;
			}
			temp = temp >> 1;
			exp = exp >> 1;
		}
		
		if(neg) return -ans;
		else return ans;
	}
	
	// Memory Limit Exceeded?
//	public int divide(int dividend, int divisor) {
//		if(divisor > dividend) return 0;
//		Stack<Integer> mulN = new Stack<Integer>();
//		Stack<Integer> mul2 = new Stack<Integer>();
//		int temp = divisor, exp = 1, ans = 0;
//		
//		mulN.add(temp);
//		mul2.add(exp);
//		while(temp <= dividend / 2){
//			temp += temp;
//			exp += exp;
//			mulN.add(temp);
//			mul2.add(exp);	
//		}
//		
//		while(!mulN.isEmpty()){
//			if(dividend >= mulN.peek()){
//				ans += mul2.peek();
//				dividend -= mulN.peek();
//			}
//			mulN.pop();
//			mul2.pop();
//		}
//		
//		return ans;
//	}
}
