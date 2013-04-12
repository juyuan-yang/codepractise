/*
 * Anagrams - Mar 19 '12 - 646 / 2157
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
 */

package week7.Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public ArrayList<String> anagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		ArrayList<String> res = new ArrayList<String>();
		if(strs == null) return res;
		for(int i = 0; i < strs.length; i++){
			String dicStr = getDicOrder(strs[i]);
			if(map.containsKey(dicStr))
				map.get(dicStr).add(strs[i]);
			else {
				ArrayList<String> item = new ArrayList<String>();
				item.add(strs[i]);
				map.put(dicStr, item);
			}
		}

		for(Map.Entry<String, List<String>> entry : map.entrySet()){
			if(entry.getValue().size() > 1)
				for(String s : entry.getValue()){
					res.add(s);
				}
		}
		return res;
	}
	
	public String getDicOrder(String str){
		char[] chs = new char[str.length()];
		for(int i = 0; i < str.length(); i++)
			chs[i] = str.charAt(i);
		for(int i = 0; i < str.length() - 1; i++)
			for(int j = 0; j < str.length() - 1 - i; j++){
				if(chs[j] > chs[j+1]){
					char ch = chs[j];
					chs[j] = chs[j+1];
					chs[j+1] = ch;
				}
			}
		return new String(chs);
	}
}
