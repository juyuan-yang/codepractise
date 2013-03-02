package twoSum;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *  * From Leetcode Online Judge
 * Problem: Two Sum
 * Finished on 3/1/2013
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
 * are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * @author jielu
 *
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(numbers == null || numbers.length < 2)
    		return null;
    	
    	HashMap<Integer, Integer> diffMap = new HashMap<Integer, Integer>();
    	for(int i=0; i<numbers.length; i++){
    		if(numbers[i] < target){
    			Integer beforeIdx = diffMap.get(numbers[i]);
    			if(beforeIdx != null){
    				return new int[]{beforeIdx, i + 1};
    			}
    			
    			diffMap.put(target-numbers[i], i + 1);
    		}
    	}
    	
    	
    	return null;
    
    	
        
    }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
