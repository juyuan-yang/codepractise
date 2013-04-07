/*
 * Word Ladder II - Feb 11
 * 
 * Given two words (start and end), and a dictionary, 
 * find all shortest transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * 
 * For example,
 * 
 * Given:
 *  start = "hit"
 *  end = "cog"
 *  dict = ["hot","dot","dog","lot","log"]
 * 
 * Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
 * 
 * Note:
    All words have the same length.
    All words contain only lowercase alphabetic characters.
 */

package week1.WordLadder2;

/*
 * Discussion for this problem:
 * http://www.mitbbs.com/article_t1/JobHunting/32325007_0_3.html
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

// The code looks like a shit... Need rewrite later...
public class solution {
	public static void main(String[] args) {
		String[] strs = new String[] { "hot", "cog", "dog", "tot", "hog",
				"hop", "pot", "dot" };
		HashSet<String> set = new HashSet<String>();
		for (String s : strs)
			set.add(s);

		System.out.println(findLadders("hot", "dog", set));
		// System.out.println(strs.length);
	}

	public static ArrayList<ArrayList<String>> findLadders(String start,
			String end, HashSet<String> dict) {
		if (!dict.contains(start) || !dict.contains(end))
			return null;
		int res = 1;
		HashSet<String> toCheck = new HashSet<String>();
		Map<String, Boolean> visit = new HashMap<String, Boolean>();
		Map<String, List<String>> ancestor = new HashMap<String, List<String>>();
		for (String s : dict) {
			visit.put(s, false);
			List<String> list = new ArrayList<String>();
			ancestor.put(s, list);
		}

		toCheck.add(start);
		visit.put(start, true);
		while (!toCheck.contains(end) && toCheck.size() > 0) {
			res++;
			HashSet<String> newStrs = new HashSet<String>();
			for (String s : toCheck) {
				newStrs.addAll(oneDiffStrs(s, dict, visit, ancestor));
			}
			for (String s : newStrs)
				visit.put(s, true);
			toCheck = newStrs;
//			System.out.println(toCheck);
		}
		ArrayList<ArrayList<String>> finalRes = new ArrayList<ArrayList<String>>();
		if (toCheck.contains(end)) {
			String[] results = new String[res];
			results[0] = end;
			visitPath(end, ancestor, results, 1, finalRes);
		}
//		System.out.println(ancestor);
		return finalRes;
	}

	public static void visitPath(String str,
			Map<String, List<String>> ancestor, String[] result, int index,
			ArrayList<ArrayList<String>> finalRes) {
		if (index == result.length) {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = index - 1; i >= 0; i--)
				list.add(result[i]);
			finalRes.add(list);
			return;
		}
		List<String> strs = ancestor.get(str);
		for (String s : strs) {
			result[index] = s;
			visitPath(s, ancestor, result, index + 1, finalRes);
		}
	}

	public static List<String> oneDiffStrs(String str, HashSet<String> dict,
			Map<String, Boolean> visit, Map<String, List<String>> ancestor) {
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < 26; j++) {
				char[] orig = str.toCharArray();
				orig[i] = (char) ('a' + j);
				String newStr = new String(orig);
				if (dict.contains(newStr)) {
					if (visit.get(newStr) == false) {
						res.add(newStr);
						ancestor.get(newStr).add(str);
					}
				}
			}
		}
		return res;
	}
}
