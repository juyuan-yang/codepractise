/*
Substring with Concatenation of All Words - Feb 24 '12 - 3026 / 11185
You are given a string, S, and a list of words, L, that are all of the same length.
Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once
and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 */

package week12.SubstringwithConcatenationofAllWords;

import java.util.*;

public class Solution {
    boolean[] appear;
    Map<Integer, ArrayList<Integer>> map;
    Set<Integer> set;
    ArrayList<Integer> res;
    String S;
    String[] L;

    public ArrayList<Integer> findSubstring(String S, String[] L) {
        res = new ArrayList<Integer>();
        if(S == null || S.length() == 0) return res;
        if(L == null || L.length == 0) return res;
        this.S = S;
        this.L = L;

        appear = new boolean[L.length];
        // index of S, to words starting at this postion
        map = new HashMap<Integer, ArrayList<Integer>>();
        set = new HashSet<Integer>();

        for(int i = 0; i < S.length(); i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            map.put(i, list);
        }

        for(int i = 0; i < L.length; i++){
            if(i > 0 && L[i].equals(L[i-1])){
                map.put(i, map.get(i-1));
                continue;
            }
            int index = S.indexOf(L[i]);
            while(index != -1){
                map.get(index).add(i);
                index = S.indexOf(L[i], index + L[i].length());
            }
        }

        for(int i = 0; i <= S.length() - L.length * L[0].length(); i++){
            if(map.get(i).size() > 0){
                iter(0, i);
            }
        }

        res.addAll(set);
        return res;
    }

    public void iter(int total, int strIndex){
        if(total == L.length){
            set.add(strIndex - L.length * L[0].length());
            return;
        }
        Set<String> dup = new HashSet<String>();
        for(int index : map.get(strIndex)){
            if(!appear[index] && !dup.contains(L[index])){
                appear[index] = true;
                iter(total + 1, strIndex + L[index].length());
                appear[index] = false;
                dup.add(L[index]);
            }
        }
    }
}
