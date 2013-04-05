/*
 * Insert Interval - Mar 27 '12 - 232 / 1080
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

package week7.InsertInterval;

import java.util.ArrayList;

import all.Interval;

public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    	ArrayList<Interval> res = new ArrayList<Interval>();
        for(int i = 0; i < intervals.size(); i++){
        	Interval cur = intervals.get(i);
        	if(cur.end < newInterval.start || cur.start > newInterval.end) res.add(cur);
        	else {
        		newInterval.start = (newInterval.start < cur.start) ? newInterval.start : cur.start;
        		newInterval.end = (newInterval.end < cur.end) ? cur.end : newInterval.end;
        	}
        }
    	
        int pos = 0;
        while(pos < res.size() && res.get(pos).start < newInterval.start) pos++;
        res.add(pos, newInterval);
    	return res;
    }
}
