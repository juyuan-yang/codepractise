/*
 * Pow(x, n) - Mar 20 '12 - 848 / 2144
Implement pow(x, n).
 */

package week7.Pow_x_n;

import java.util.Stack;

public class Solution {
	// An interesting test case: -1, -2147483648
    public double pow(double x, int n) {
        if(n == 0) return 1;
        else if(n > 0) return binpow(x, n);
        else{
            if(n == -1) return 1 / binpow(x, 1);
            double ans = binpow(x, - (n / 2));
        	if(n % 2 == 0) return 1 / (ans * ans);
        	return 1 / (ans * ans * x);
        }
    }
    
    public double binpow(double x, int n){
        Stack<Integer> nums = new Stack<Integer>();
        while(n > 1){
        	nums.add(n);
        	n /= 2;
        }
        double ans = x;
        while(!nums.isEmpty()){
        	ans *= ans;
        	if(nums.pop() % 2 == 1) ans *= x; 
        }
        return ans;
    }
}
