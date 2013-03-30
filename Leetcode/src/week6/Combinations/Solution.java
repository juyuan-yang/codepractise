/*
 * Combinations - Apr 18 '12

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 */

package week6.Combinations;

import java.util.ArrayList;

public class Solution {
	ArrayList<ArrayList<Integer>> res;
    int n, k;
    int[] ans;
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        res = new ArrayList<ArrayList<Integer>>();
        this.n = n;
        this.k = k;
        if(n >= k && k > 0){
            ans = new int[k];
            visit(0, 0);
        }
        return res;
    }
    
    public void visit(int num, int end){
        if(end == k){
            ArrayList<Integer> oneAns = new ArrayList<Integer>();
            for(int i = 0; i < end; i++) oneAns.add(ans[i]);
            res.add(oneAns);
            return;
        }
        if(num == n || n - num < k - end) return;
        visit(num+1, end);
        ans[end] = num+1;
        visit(num+1, end+1);
    }
}
