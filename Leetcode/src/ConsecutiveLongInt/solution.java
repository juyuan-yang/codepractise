/*
 * Longest Consecutive Sequence - Feb 14
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Good solutions: 
 * http://blog.sina.com.cn/s/blog_b9285de20101i09x.html
 * http://blog.sina.com.cn/s/blog_b9285de20101i2fp.html
 */
package ConsecutiveLongInt;

import java.util.HashSet;

public class solution {

	public static void main(String[] args) {
		

	}

	public int findConsecutive(HashSet<Integer> hs, int target, boolean up){
		int count = 0, carry = up ? 1 : -1;
		while(hs.contains(target + carry)){
			target += carry;
			count++;
			hs.remove(target);
		}
		return count;
	}
	
	public int longestConsecutive(int[] num) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int n : num) hs.add(n);
        	
        int ans = 0;
        for(int n : num){
        	if(hs.contains(n)){
        		int temp = findConsecutive(hs, n, true) + findConsecutive(hs, n, false) + 1;
        		hs.remove(n);
        		if(temp > ans) ans = temp;
        	}
        }
        return ans;
    }
}
