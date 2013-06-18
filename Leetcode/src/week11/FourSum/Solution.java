package week11.FourSum;

import java.util.ArrayList;

public class Solution {
    ArrayList<ArrayList<Integer>> res;
    int[] array;
    public ArrayList<ArrayList<Integer>> myMethod(int[] array, int target){
        res = new ArrayList<ArrayList<Integer>>();
        this.array = array;
        quicksort(0, array.length - 1);
        int start = 0, end = array.length - 1;
        while(end - start > 2){
            int s = start + 1, e = end - 1;
            while(s < e){
                int total = array[start] + array[s] + array[e] + array[end];
                if(total == target){
                    ArrayList<Integer> item = new ArrayList<Integer>();
                    item.add(array[start]);
                    item.add(array[s]);
                    item.add(array[e]);
                    item.add(array[end]);
                    res.add(item);
                    s++;
                    e--;
                } else if(total < target){
                    s++;
                } else {
                    e--;
                }
            }
            do{
                start++;
            } while(array[start] == array[start-1] && start < end);
            do{
                end--;
            } while(start < end && array[end] == array[end+1]);
        }
        return res;
    }

    public void quicksort(int s, int t) {
        int i = s, j = t;
        int temp = array[s];

        while(i < j){
            while(i < j && array[j] > temp) j--;
            if(i < j){
                array[i] = array[j];
                i++;
            }
            while(i < j && array[i] < temp) i++;
            if(i < j){
                array[j] = array[i];
                j--;
            }
        }

        if(s < i - 1) quicksort(s, i-1);
        if(i + 1 < t) quicksort(i+1, t);
    }
}
