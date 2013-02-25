package stock2;

/**
 * From Leetcode Online Judge
 * Problem: Best Time to Buy and Sell Stock2
 * Finished on 2/24/2013
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * @author jielu
 *
 */
public class Solution {
	public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
		/*
		 * Looks I over thought the problem....
		 if(prices == null || prices.length < 1)
			return 0;
		
		int maxProfit = 0;
		int globalMin = 0; // Lowest price before the current price
		int localMin = 0;  // Lowest price before the current price since last sell
		
		for(int i=1; i<prices.length ; i++){
			int tempMax = (prices[i] - prices[globalMin]) > (prices[i] - prices[localMin] + maxProfit) 
					? (prices[i] - prices[globalMin]) : (prices[i] - prices[localMin] + maxProfit);
			if(tempMax > maxProfit){
				maxProfit = tempMax;
				localMin = i;
			}
			
			if(prices[i] < prices[globalMin]) globalMin = i;
			if(prices[i] < prices[localMin]) localMin = i;
		}
		
		
		return maxProfit; */
		
		int maxProfit = 0;
		for(int i=1; i<prices.length; i++){
			if(prices[i] > prices[i-1])
				maxProfit += prices[i] - prices[i-1];
		}
		
		return maxProfit;
		
        
    }

}
