package week11.FourSum;

import java.util.ArrayList;

public class Solution {
    ArrayList<ArrayList<Integer>> res;
    int[] num;
    // sometimes pass, sometimes time limit exceed, there must be better solution
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 4) return res;
        this.num = num;
        quicksort(0, num.length - 1);
        for(int start = 0; start <= num.length - 4; start++){
            if(start != 0 && num[start] == num[start-1]) continue;
            for(int end = num.length-1; end > start + 2; end--){
                if(end != num.length-1 && num[end] == num[end+1]) continue;
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
                        do{
                            s++;
                        } while(s < e && num[s] == num[s-1]);
                        do{
                            e--;
                        } while (s < e && num[e] == num[e+1]);
                    } else if(total < target){
                        do{
                            s++;
                        } while(s < e && num[s] == num[s-1]);
                    } else {
                        do{
                            e--;
                        } while(s < e && num[e] == num[e+1]);
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
