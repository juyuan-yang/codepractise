/*
 * Subsets - Apr 18 '12

Given a set of distinct integers, S, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 */

package week6.Subsets;

import java.util.ArrayList;

public class Solution {
    ArrayList<ArrayList<Integer>> res;
    int[] S;
    int[] ans;
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        res = new ArrayList<ArrayList<Integer>>();
        this.S = S;
        if(S != null && S.length > 0){
            quicksort(0, S.length - 1);
            ans = new int[S.length];
            visit(0, 0);
        }
        return res;
    }
    
    public void visit(int pos, int end){
        if(pos == S.length){
            ArrayList<Integer> oneAns = new ArrayList<Integer>();
            for(int i = 0; i < end; i++) oneAns.add(ans[i]);
            res.add(oneAns);
            return;
        }
        visit(pos+1, end);
        ans[end] = S[pos];
        visit(pos+1, end+1);
    }
    
    public void quicksort(int s, int t){
        int i = s, j = t;
        int temp = S[s];
        while(i < j){
            while(i < j && S[j] > temp) j--;
            if(i < j){
                S[i] = S[j];
                i++;
            }
            while(i < j && S[i] < temp) i++;
            if(i < j){
                S[j] = S[i];
                j--;
            }
        }
        S[i] = temp;
        if(s < i-1)quicksort(s, i-1);
        if(i+1 < t)quicksort(i+1, t);
    }
}
