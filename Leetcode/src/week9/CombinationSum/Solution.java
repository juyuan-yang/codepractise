/*
 * Combination Sum - Mar 7 '12 - 989 / 2592

Given a set of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3] 
 */

package week9.CombinationSum;

import java.util.ArrayList;

public class Solution {
	ArrayList<ArrayList<Integer>> res;
    int[] array;
    int[] candidates;
    int target;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<ArrayList<Integer>>();
        this.candidates = candidates;
        this.target = target;
        if(candidates != null && candidates.length > 0){
        	quicksort(0, candidates.length - 1);
            if(candidates[0] <= target){
                array = new int[target / candidates[0] + 1];
                visit(0, 0, 0);
            }
        }
        return res;
    }
    
    public void visit(int pos, int index, int total){
        if(index >= candidates.length || pos >= array.length) return;
        if(total < target) visit(pos, index+1, total);
        for(int i = 0; i < target / candidates[index]; i++){
            array[pos + i] = candidates[index];
            total += candidates[index];
            if(total == target){
            	ArrayList<Integer> item = new ArrayList<Integer>();
            	for(int j = 0; j <= pos + i; j++)
            		item.add(array[j]);
            	res.add(item);
            	return;
            } else if(total < target) {
            	visit(pos+i+1, index+1, total);
            } else
            	return;
        }
    }
    
    public void quicksort(int s, int t){
    	int temp = candidates[s];
    	int i = s, j = t;
    	while(i < j){
    		while(i < j && candidates[j] > temp) j--;
    		if(i < j){
    			candidates[i] = candidates[j];
    			i++;
    		}
    		while(i < j && candidates[i] < temp) i++;
    		if(i < j){
    			candidates[j] = candidates[i];
    			j--;
    		}
    	}
    	candidates[i] = temp;
    	if(s < i - 1) quicksort(s, i - 1);
    	if(i + 1 < t) quicksort(i + 1, t);
    }
}
