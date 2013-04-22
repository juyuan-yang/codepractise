/*
 * Merge Intervals - Mar 27 '12 - 345 / 1388
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */

package week7.MergeIntervals;

import java.util.ArrayList;

import all.helper.Interval;

public class Solution {
	ArrayList<Interval> intervals;
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    	ArrayList<Interval> res = new ArrayList<Interval>();
    	this.intervals = intervals;
    	if(intervals.size() > 0){
    		quicksort(0, intervals.size() - 1);
    		Interval temp = intervals.get(0);
    		for(int i = 1; i < intervals.size(); i++){
    			Interval item = intervals.get(i);
    			if(temp.end > item.start && item.end > temp.start){
    				if(temp.start > item.start) temp.start = item.start;
    				if(temp.end < item.end) temp.end = item.end;
    			} else {
    				res.add(temp);
    				temp = item;
    			}
    		}
    		res.add(temp);
    	}
    	return res;
    }
    
    public void quicksort(int s, int t){
    	int i = s, j = t;
    	Interval temp = intervals.get(s);
    	while(i < j){
    		while(i < j && intervals.get(j).start > temp.start) j--;
    		if(i < j){
    			intervals.set(i++, intervals.get(j));
    		}
    		while(i < j && intervals.get(i).start < temp.start) i++;
    		if(i < j){
    			intervals.set(j--, intervals.get(i));
    		}
    	}
    	intervals.set(i, temp);
    	if(s < i-1) quicksort(s, i-1);
    	if(i+1 < t) quicksort(i+1, t);
    }
}
