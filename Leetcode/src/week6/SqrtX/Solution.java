/*
 * Sqrt(x) - Apr 3 '12 - 473 / 1957
Implement int sqrt(int x).

Compute and return the square root of x.
 */

package week6.SqrtX;

public class Solution {
	/*
	 * Solutions:
	 * 1. Binary search, using double to deal with overflow
	 * 2. Binary search, using target/x to compare with x, instead of x*x with target
	 * 3. Newton iteration (Like this, any improvement?)
	 * 4. Karmak amazing solution
	 * 5. Infer from x = 10p + q -> x*x = 100 p*p + 20pq + q*q
	 */
    public int sqrt(int x) {
        if(x < 1) return 0;
        if(x < 4) return 1;
        int ans = x / 2, pre;
        do{
            pre = ans;
            ans = (ans + x / ans) / 2;
            if(pre < ans) return pre;
        } while(ans != pre);
        
        return ans;
    }
}
