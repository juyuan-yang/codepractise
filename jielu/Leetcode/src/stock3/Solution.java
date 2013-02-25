package stock3;

/**
 * From Leetcode Online Judge
 * Problem: Best Time to Buy and Sell Stock3
 * Finished on 2/24/2013
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * @author jielu
 *
 */
public class Solution {
	//Optimized version
	public int maxProfit(int[] prices){
		if(prices == null || prices.length <= 1) return 0;
		
		// Calculate the max profit end at index i
		int[] forwardMaxProfits = new int[prices.length];
		int low = 0;
		int forwardMaxProfit = 0;
		
		for(int i=1; i<prices.length; i++){
			int profit = prices[i] - prices[low];
			if(profit > forwardMaxProfit)
				forwardMaxProfit = profit;
			
			if(prices[i] < prices[low])
				low = i;
			
			forwardMaxProfits[i] = forwardMaxProfit;
		}
		
		// Calculate the max profit between i and n-1, and calculate the final max profits
		int high = prices.length - 1;
		int backwardMaxProfit = 0;
		int finalMaxProfit = forwardMaxProfits[prices.length - 1];
		
		for(int i=prices.length - 1; i>=0; i--){
			int profit = prices[high] - prices[i];
			if(profit > backwardMaxProfit)
				backwardMaxProfit = profit;
			
			if(prices[i] > prices[high])
				high = i;
			
			int totalProfit = forwardMaxProfits[i] + backwardMaxProfit;
			if(totalProfit > finalMaxProfit)
				finalMaxProfit = totalProfit;
		}
		
		return finalMaxProfit;
		
	}
	
	//Brutal solution
	 public int maxProfit1(int[] prices) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 if(prices == null || prices.length <= 1) return 0;
		 
		 int maxProfit = subMaxProfit(prices, 0, prices.length-1);
		 for(int i=0; i<prices.length-1; i++){
			 int temp = subMaxProfit(prices, 0, i) + subMaxProfit(prices, i+1, prices.length -1);
			 if(temp > maxProfit) maxProfit = temp; 
		 
		 }
		 
		 return maxProfit;
	    }
	 
	 public int subMaxProfit(int[] prices, int start, int end){
		 if(start >= end) return 0;
		 
		 int maxProfit = 0;
		 int min = start;
		 
		 for(int i=start + 1; i<=end; i++){
			 if(prices[i] - prices[min] > maxProfit) maxProfit = prices[i] - prices[min];
			 if(prices[i] < prices[min]) min = i;
		 }
		 
		 return maxProfit;
	 }
	 
	
}
