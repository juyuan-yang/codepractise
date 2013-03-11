package longestConsecutiveSequence;

import java.util.HashSet;

/**
 * From Leetcode online judge
 * Problem: Longest Consecutive Sequence
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * Finished on 3/7/2013
 * @author jielu
 *
 */
public class Solution {
	
	public static int longestConsecutive(int[] num) {
        int maxLen = 0;
        
        // Add each number in the array to the hashset first
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i =0; i<num.length; i++){
        	set.add(num[i]);
        }
        
        for(int i=0; i<num.length; i++){
        	int currentLen = 0;
        	int currentNum = num[i];
        	
        	if(set.contains(currentNum)){
        		currentLen ++;
        		set.remove(currentNum);
        		int temp = currentNum + 1;
        		while(set.contains(temp)){
        			currentLen ++;
        			set.remove(temp);
        			temp ++;
        		}
        		
        		temp = currentNum - 1;
        		while(set.contains(temp)){
        			currentLen ++;
        			set.remove(temp);
        			temp --;
        		}
        	}
        	
        	if(currentLen > maxLen)
        		maxLen = currentLen;
        	
        	
        }
		
		return maxLen;
        
    }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[]{100, 4, 200, 1, 3, 2};
		System.out.println(Solution.longestConsecutive(num));

	}

}
