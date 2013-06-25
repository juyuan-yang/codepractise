/*
Container With Most Water - Jan 9 '12 - 2406 / 5335

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
 */
package week12.ContainerWithMostWater;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // time limit exceed
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        List<Integer> increase = new ArrayList<Integer>();
        increase.add(0);
        int max = 0, temp;
        for(int i = 1; i < height.length; i++){
            int lastIndex = increase.get(increase.size()-1);
            for(int j = 0; j < increase.size(); j++){
                temp = getMin(height[i], height[increase.get(j)]) * (i - increase.get(j));
                if(temp > max) max = temp;
                if(height[i] < height[increase.get(j)]) break;
                if(height[lastIndex] * (i - increase.get(j)) < max) break;
            }
            if(height[lastIndex] < height[i]){
                increase.add(i);
            }
        }
        return max;
    }

    public int getMin(int x, int y){
        return (x < y) ? x : y;
    }
}
