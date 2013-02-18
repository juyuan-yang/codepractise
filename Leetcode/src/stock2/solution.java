/*
 * Best Time to Buy and Sell Stock II - Oct 31 '12 
 * Say you have an array for which the ith element is the price of a given stock on day i. 
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 */
package stock2;

public class solution {

	public static void main(String[] args) {
		int[] prices = new int[]{6,1,3,2,4,7};
		System.out.println(maxProfit(prices));
	}
	
    public static int maxProfit(int[] prices) {
    	int total = 0;
        for(int i = 1; i < prices.length; i++){
        	if(prices[i] > prices[i - 1]) 
        		total += (prices[i] - prices[i - 1]);
        }
    	return total;
    }
}
