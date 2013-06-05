/*
3Sum - Jan 18 '12 - 3748 / 13968
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */

package week11.ThreeSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: juyuan.yang
 * Date: 5/28/13
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    // very tricky solution for me... very interesting!
    ArrayList<ArrayList<Integer>> res;
    int[] num;
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        res = new ArrayList<ArrayList<Integer>>();
        this.num = num;
        if(num == null || num.length < 3) return res;
        quicksort(0, num.length - 1);
        for(int i = 0; i <= num.length - 3; i++){
            if(i != 0 && num[i] == num[i-1]) continue;
            int start = i+1, end=num.length-1;
            while(start < end){
                int total = num[i] + num[start] + num[end];
                if(total == 0){
                    ArrayList<Integer> item = new ArrayList<Integer>();
                    item.add(num[i]);
                    item.add(num[start]);
                    item.add(num[end]);
                    res.add(item);
                    start++;
                    end--;
                    while(start < end && num[end] == num[end+1]) end--;
                    while(start < end && num[start] == num[start-1]) start++;
                } else if(total < 0){
                    start++;
                    while(start < end && num[start] == num[start-1]) start++;
                } else {
                    end--;
                    while(start < end && num[end] == num[end+1]) end--;
                }
            }
        }

        return res;
    }

    public void quicksort(int s, int t){
        int i = s, j = t;
        int temp = num[i];
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
        if(s < i - 1) quicksort(s, i-1);
        if(i + 1 < t) quicksort(i+1, t);
    }

    // time limit exceeds
//    ArrayList<ArrayList<Integer>> res;
//    int[] temp;
//    int[] num;
//    HashSet<ArrayList<Integer>> set;
//    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
//        res = new ArrayList<ArrayList<Integer>>();
//        temp = new int[3];
//        this.num = num;
//        set = new HashSet<ArrayList<Integer>>();
//        if(num != null && num.length > 0 ){
//            tryEle(0, 0, 0);
//        }
//        return res;
//    }
//
//    public void tryEle(int pos, int seq, int total){
//        if(pos == 3){
//            if(total != 0) return;
//
//            ArrayList<Integer> item = new ArrayList<Integer>();
//            item.add(temp[0]);
//            item.add(temp[1]);
//            item.add(temp[2]);
//            if(item.get(0) > item.get(1)) swap(0, 1, item);
//            if(item.get(1) > item.get(2)) swap(1, 2, item);
//            if(item.get(0) > item.get(1)) swap(0, 1, item);
//
//            if(!set.contains(item)) {
//                res.add(item);
//                set.add(item);
//            }
//            return;
//        }
//        for(int i = seq; i < num.length; i++){
//            temp[pos] = num[i];
//            tryEle(pos + 1, i + 1, total + num[i]);
//        }
//    }
//
//    public void swap(int i, int j, ArrayList<Integer> item){
//        int t = item.get(i);
//        item.set(i, item.get(j));
//        item.set(j, t);
//    }
}
