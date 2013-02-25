package stock1;

/**
 * From Leetcode Online Judge
 * Problem: Best Time to Buy and Sell Stock
 * Finished on 2/24/2013
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * @author jielu
 *
 */
public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
    	/* 
    	 * Brutal solution
    	int maxProfit = 0;
    	
    	for(int i=0; i<prices.length - 1; i++){
    		for(int j = i + 1; j<prices.length; j++){
    			if(prices[j] - prices[i] > maxProfit){
    				maxProfit = prices[j] - prices[i];
    			}
    		}
    	}
        
    	return maxProfit;
    	*/
    	
    	//////////////////////////////////////////////////////
    	/*
    	 * Optimized solution
    	 */
    	if(prices == null || prices.length == 0)
    		return 0;
    	
    	int min = 0;
    	int maxProfit = 0;
    	for(int i=1; i<prices.length; i++){
    		if(prices[i] - prices[min] > maxProfit){
    			maxProfit = prices[i] - prices[min];
    		}
    		
    		if(prices[min] > prices[i]){
    			min = i;
    		}
    	}
    	
    	return maxProfit;
    }
}