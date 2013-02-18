/*
 * Best Time to Buy and Sell Stock - Oct 30 '12
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 */

package stock1;

public class solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++){
        	if(prices[i] - min > max) max = prices[i] - min;
        	if(prices[i] < min) min = prices[i];
        }
    	return max;
    }
}
