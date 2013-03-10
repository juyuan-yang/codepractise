/*
 * Palindrome Partitioning II - Mar 1

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
 */

package PalindromePartitioning2;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    ArrayList<ArrayList<Integer>> pairs; // to record [start, end] palindrome pairs
    String s;
    
    public int minCut(String s) {
        pairs = new ArrayList<ArrayList<Integer>>(s.length());
        this.s = s;
        if(s != null || s.length() > 0){
            findAllPairs();
        }
        return findSol();
    }
    // res array has s.length + 1 elements
    // as I need res[0] = 0 as an initial condition
    // res stores how many palindromes at each index, so the min cut needs -1
    // DP formula: if there is a palindrome [start, end], then
    //     res[end] = min{res[end], res[start-1] + 1}
    public int findSol(){
        int[] res = new int[s.length() + 1];
    	for(int i = 0; i <= s.length(); i++) res[i] = i;
    	for(int i = 0; i < s.length(); i++){
    		ArrayList<Integer> pair = pairs.get(i);
    		for(int j = 0; j < pair.size(); j++){
    			int end = pair.get(j);
    			if(res[end+1] > res[i]) res[end+1] = res[i]+1;
    		}
    	}
    	return res[s.length()] - 1;
    }
    
    public void findAllPairs(){
    	for(int i = 0; i < s.length(); i++){
    		ArrayList<Integer> list = new ArrayList<Integer>();
    		pairs.add(list);
    	}
        for(int i = 0; i < s.length(); i++){
            int start = i, end = i;
            pairs.get(start).add(end);
            tryPairs(start, end);
        }
        for(int i = 1; i < s.length(); i++){
            int start = i - 1, end = i;
            if(s.charAt(start) == s.charAt(end)){
            	pairs.get(start).add(end);
            	tryPairs(start, end);
            }
        }
    }
    
    public void tryPairs(int start, int end){
    	while(start > 0 && end + 1 < s.length()){
            if(s.charAt(start - 1) == s.charAt(end + 1)){
                 start--;
                 end++;
                 pairs.get(start).add(end);
             } else break;
         }
    }
}
