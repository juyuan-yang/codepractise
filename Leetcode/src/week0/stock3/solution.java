/*
 * Best Time to Buy and Sell Stock III - Nov 7 '12
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
package week0.stock3;

public class solution {

	public static void main(String[] args) {
		int[] prices = new int[]{6,1,3,2,4,7};
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		if(prices.length <= 1) return 0;
		
		int[] profits = new int[prices.length]; 
        int min = prices[0], maxPro = profits[0] = 0;
        for(int i = 1; i < prices.length; i++){
        	if(prices[i] - min > maxPro) maxPro = prices[i] - min;
        	if(prices[i] < min) min = prices[i];
        	profits[i] = maxPro;
        }
        
        int max = prices[prices.length - 1];
        int res = maxPro;
        maxPro = 0;
        for(int i = prices.length - 2; i >= 0; i--){
        	if(max - prices[i] > maxPro) maxPro = max - prices[i];
        	if(prices[i] > max) max = prices[i];
        	if(i > 0){
        		if(maxPro + profits[i - 1] > res) res = maxPro + profits[i - 1];
        	}
        }
        return res;
	}
	
	// slow version
    public static int maxProfit1(int[] prices) {
        if(prices.length <= 1) return 0;
        int max = partMax(prices, 0, prices.length - 1), min = -1;
        for(int i = 1; i < prices.length; i++){
        	if(prices[i] > prices[i - 1]){
        		if(min == -1) min = prices[i - 1];
        	} else {
        		if(min != -1){
        			int res = partMax(prices, 0, i - 1) 
        					+ partMax(prices, i, prices.length - 1);
        			if(res > max) max = res;
        			min = -1;
        		}
        	}
        }
    	return max;
    }
    
    public static int partMax(int[] prices, int start, int end){
    	if(end == start) return 0;
    	int min = prices[start], max = 0;
    	for(int i = start + 1; i <= end; i++){
    		if(prices[i] - min > max) max = prices[i] - min;
    		if(prices[i] < min) min = prices[i];
    	}
    	return max;
    }
}
