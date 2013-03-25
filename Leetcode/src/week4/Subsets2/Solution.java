/*
 * Subsets II - Jun 25 '12
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */

package week4.Subsets2;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(subsetsWithDup(new int[]{4, 1, 0}));
	}

    int[] num;
	int[] temp;
	ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        this.num = num;
        res = new ArrayList<ArrayList<Integer>>();
        if(num.length > 0){
        	temp = new int[num.length];
        	quickSort(0, num.length - 1);
        	visit(0, 0);
        }
    	return res;
    }
    
    public void visit(int i, int end){
    	if(i == num.length){
    		ArrayList<Integer> ans = new ArrayList<Integer>(end);
    		for(int l = 0; l < end; l++) ans.add(temp[l]);
    		res.add(ans);
    		return;
    	}
    	int j = i + 1;
    	while(j < num.length && num[j] == num[i]) j++;
    	if(j == i + 1){ // no duplicate
    		visit(i + 1, end);
    		temp[end] = num[i];
    		visit(i + 1, end + 1);
    	} else { // duplicates
    		visit(j, end);
    		for(int l = 1; l <= j - i; l++){
    			temp[end + l - 1] = num[i];
    			visit(j, end + l);
    		}
    	}
    }
    
    public void quickSort(int s, int t){
    	int i = s, j = t;
    	int temp = num[s];
    	while(i < j){
    		while(i < j && temp < num[j]) j--;
    		if(i < j){
    			num[i] = num[j];
    			i++;
    		}
    		while(i < j && num[i] < temp) i++;
    		if(i < j){
    			num[j] = num[i];
    			j--;
    		}
    	}
    	num[i] = temp;
    	if(s < i-1) quickSort(s, i-1);
    	if(i+1 < t) quickSort(i+1, t);
    }
}
