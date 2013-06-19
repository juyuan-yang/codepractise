package week11.FourSum;

import java.util.ArrayList;

public class Solution {
    ArrayList<ArrayList<Integer>> res;
    int[] num;
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 4) return res;
        this.num = num;
        quicksort(0, num.length - 1);
        for(int start = 0; start <= num.length - 4; start++){
            for(int end = start + 3; end < num.length; end++){
                int s = start + 1, e = end - 1;
                while(s < e){
                    int total = num[start] + num[s] + num[e] + num[end];
                    if(total == target){
                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(num[start]);
                        item.add(num[s]);
                        item.add(num[e]);
                        item.add(num[end]);
                        res.add(item);
                        s++;
                        e--;
                    } else if(total < target){
                        s++;
                    } else {
                        e--;
                    }
                }
            }
        }
        return res;
    }

    public void quicksort(int s, int t) {
        int i = s, j = t;
        int temp = num[s];

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
}
