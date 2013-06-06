/*
3 Sum Closest - Jan 18 '12 - 2229 / 5550
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

package week11.ThreeSumClosest;

/**
 * Created with IntelliJ IDEA.
 * User: juyuan.yang
 * Date: 5/30/13
 * Time: 8:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {

    int[] num;
    public int threeSumClosest(int[] num, int target) {
        this.num = num;
        if(num == null || num.length < 3) return 0;
        int closest = num[0] + num[1] + num[2];
        quicksort(0, num.length - 1);
        for(int i = 0; i <= num.length - 3; i++){
            if(i != 0 && num[i] == num[i-1]) continue;
            int start = i+1, end=num.length-1;
            while(start < end){
                int total = num[i] + num[start] + num[end];
                if(total == target){
                    return target;
                } else {
                    if(Math.abs(target - closest) > Math.abs(target - total))
                        closest = total;
                    if(total < target){
                        start++;
                        while(start < end && num[start] == num[start-1]) start++;
                    } else {
                        end--;
                        while(start < end && num[end] == num[end+1]) end--;
                    }
                }
            }
        }
        return closest;
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
//    int[] temp;
//    int[] num;
//    int cloest;
//    int target;
//    public int threeSumClosest(int[] num, int target) {
//        temp = new int[3];
//        this.num = num;
//        this.target = target;
//        if(num != null && num.length > 0 ){
//            cloest = num[0] + num[1] + num[2];
//            tryEle(0, 0, 0);
//        }
//        return cloest;
//    }
//
//    public void tryEle(int pos, int seq, int total){
//        if(pos == 3){
//            if(Math.abs(target - total) < Math.abs(target - cloest))
//                cloest = total;
//            return;
//        }
//        for(int i = seq; i < num.length; i++){
//            temp[pos] = num[i];
//            tryEle(pos + 1, i + 1, total + num[i]);
//        }
//    }
}
