/*
 * Permutation Sequence - Mar 28 '12 - 202 / 736
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 */

package week7.PermutationSequence;

public class Solution {
    public String getPermutation(int n, int k) {
        int[] muls = new int[10];
        boolean[] used = new boolean[10];
        muls[0] = 1;
        for(int i = 1; i < 10; i++) {
            muls[i] = muls[i-1] * i;
            used[i] = false;
        }
        
        String ans = "";
        k--;
        for(int i = n - 1; i >= 0; i--){
            int t = k / muls[i] + 1;
            k = k % muls[i];
            for(int j = 1; j <= n; j++){
                if(!used[j]) t--;
                if(t == 0){
                    ans += j;
                    used[j] = true;
                    break;
                }
            }
        }
        return ans;
    }
}
