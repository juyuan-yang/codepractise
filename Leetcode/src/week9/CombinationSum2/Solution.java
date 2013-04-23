/*
/
 * Combination Sum II - Mar 7 '12 - 622 / 1952
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ... , ak) 
must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
 */

package week9.CombinationSum2;

import java.util.ArrayList;

public class Solution {
	ArrayList<ArrayList<Integer>> res;
    int[] array;
    int[] num;
    int[] appears;
    int target, length;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        res = new ArrayList<ArrayList<Integer>>();
        this.num = num;
        this.target = target;
        if(num != null && num.length > 0){
        	quicksort(0, num.length - 1);
            if(num[0] <= target){
                array = new int[num.length];
                appears = new int[num.length];
                length = 0;
                appears[0] = 1;
                for(int i = 1; i < num.length; i++){
                	if(num[i] != num[length]){
                		num[++length] = num[i];
                		appears[length] = 1;
                	} else 
                		appears[length]++;
                }
                length++;
                visit(0, 0, 0);
            }
        }
        return res;
    }
    
    public void visit(int pos, int index, int total){
        if(index >= length) return;
        
        if(total < target) visit(pos, index+1, total);
        
        for(int i = 0; i < appears[index]; i++) {
	        array[pos + i] = num[index];
	        total += num[index];
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
    	int temp = num[s];
    	int i = s, j = t;
    	while(i < j){
    		while(i < j && num[j] > temp) j--;
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
    	if(s < i - 1) quicksort(s, i - 1);
    	if(i + 1 < t) quicksort(i + 1, t);
    }
}
