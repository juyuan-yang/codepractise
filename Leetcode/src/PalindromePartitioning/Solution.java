/*
 * Palindrome Partitioning - Feb 28

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]

 */

package PalindromePartitioning;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		partition("abcbacddca");
//		System.out.println(pairs);
	}
	
	ArrayList<ArrayList<String>> res;
    String[] oneSol;
    ArrayList<ArrayList<Integer>> pairs; // to record [start, end] palindrome pairs
    String s;
    
    public ArrayList<ArrayList<String>> partition(String s) {
        res = new ArrayList<ArrayList<String>>();
        oneSol = new String[200];
        pairs = new ArrayList<ArrayList<Integer>>(s.length());
        this.s = s;
        if(s != null || s.length() > 0){
            findAllPairs();
        }
        findSol(0, 0);
        return res;
    }
    
    public void findSol(int start, int num){
    	if(start == s.length()){
    		ArrayList<String> sol = new ArrayList<String>();
    		for(int i = 0; i < num; i++) sol.add(oneSol[i]);
    		res.add(sol);
    		return;
    	}
    	ArrayList<Integer> pair = pairs.get(start);
    	for(int i = 0; i < pair.size(); i++){
    		int end = pair.get(i) + 1;
    		String temp = s.substring(start, end);
    		oneSol[num] = temp;
    		findSol(end, num + 1);
    	}
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
