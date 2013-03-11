package wordLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * From Leetcode online judge Problem: Word Ladder Given two words (start and
 * end), and a dictionary, find the length of shortest transformation sequence
 * from start to end, such that: Only one letter can be changed at a time Each
 * intermediate word must exist in the dictionary For example, Given: start =
 * "hit" end = "cog" dict = ["hot","dot","dog","lot","log"] As one shortest
 * transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its
 * length 5. Finished on 3/3/2013
 * 
 * @author jielu
 * 
 */
public class Solution {

	public static int ladderLength(String start, String end,
			HashSet<String> dict) {
		int minLen = Integer.MAX_VALUE;
		
		return minLen;

	}
	
	public static ArrayList<String> getAllTransforms(String start){
		ArrayList<String> result = new ArrayList<String>();
		for(int i=1; i<start.length() -1; i++){
			String prefix = start.substring(0, i);
			String surfix = start.substring(i+1, start.length());
			char curChar = start.charAt(i);
			
			for(int j=0; j<26; j++){
				char temp = (char) ('a' + j);
				if(curChar != 'a' + j){
					result.add(prefix + temp + surfix);
				}
			}
		}
		
		return result;
		
	}

	// Low performance version when dictionary is big
	// public static int ladderLength(String start, String end, HashSet<String>
	// dict) {
	// // Start typing your Java solution below
	// // DO NOT write main() function
	// if(isValidTrans(start, end))
	// return 2;
	// int minLen = Integer.MAX_VALUE;
	// boolean startFound = false;
	// String tempStart = "";
	//
	// java.util.Iterator<String> it = dict.iterator();
	// while(it.hasNext() ){
	// String el = it.next();
	// if(isValidTrans(start, el)){
	// tempStart = el;
	// startFound = true;
	// HashSet<String> dict2 = (HashSet<String>)dict.clone();
	// dict2.remove(el);
	// int tempMin = ladderLength(tempStart, end, dict2);
	//
	// if(tempMin != 0 && tempMin + 1 < minLen)
	// minLen = tempMin + 1;
	// }
	//
	// }
	//
	// if(!startFound )
	// return 0;
	//
	// return minLen < Integer.MAX_VALUE ? minLen : 0;
	// }

	public static boolean isValidTrans(String source, String target) {
		int diffCount = 0;
		for (int i = 0; i < source.length(); i++) {
			if (source.charAt(i) != target.charAt(i)) {
				diffCount++;
				if (diffCount > 1)
					return false;
			}
		}

		return diffCount == 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("cog");
		dict.add("dot");
		dict.add("dog");
		dict.add("hit");
		dict.add("lot");
		dict.add("log");

		System.out.println(Solution.ladderLength(start, end, dict));
	

	}

}
