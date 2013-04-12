/*
 * Permutations II - Mar 17 '12 - 428 / 1190
Given a collection of numbers that might contain duplicates, 
return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
 */

package week7.Permutations2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	// Actually, it is a copy from Permutation 1, only adding a set
	// TODO: any other nature ways to generate permutations with duplicate numbers?
	ArrayList<ArrayList<Integer>> res;
	Set<ArrayList<Integer>> set;
	int[] num;
	int[] ans;
	boolean[] used;
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		this.res = new ArrayList<ArrayList<Integer>>();
		this.num = num;
		this.set = new HashSet<ArrayList<Integer>>();
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
			if(!set.contains(item)){
				set.add(item);
				res.add(item);
			}
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
