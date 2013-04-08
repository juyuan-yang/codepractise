/*
 * Permutations - Mar 17 '12 - 447 / 1124
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

package week7.Permutations;

import java.util.ArrayList;

public class Solution {
	ArrayList<ArrayList<Integer>> res;
	int[] num;
	int[] ans;
	boolean[] used;
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		this.res = new ArrayList<ArrayList<Integer>>();
		this.num = num;
		if(num == null || num.length == 0) return res;
		used = new boolean[num.length];
		ans = new int[num.length];
		visit(0);
		return res;
	}
	
	public void visit(int pos){
		if(pos == num.length){
			ArrayList<Integer> item = new ArrayList<Integer>(num.length);
			for(Integer i : ans) item.add(i);
			res.add(item);
			return;
		}
		for(int i = 0; i < num.length; i++){
			if(!used[i]){
				ans[pos] = num[i];
				used[i] = true;
				visit(pos + 1);
				used[i] = false;
			}
		}
	}
}
