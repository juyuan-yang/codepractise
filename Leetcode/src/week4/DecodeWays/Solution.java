/*
 * Decode Ways - Jun 25 '12

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2. 
 */

package week4.DecodeWays;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(numDecodings("11"));

	}

    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] num = new int[s.length() + 1];
        num[0] = 1;
        if(s.charAt(0) != '0')num[1] = 1;
        for(int i = 1; i < s.length(); i++){
        	char ch1 = s.charAt(i - 1);
        	char ch2 = s.charAt(i);
        	if(ch2 != '0') num[i+1] = num[i];
        	if(ch1 == '1' || (ch1 == '2' && ch2 >= '0' && ch2 <= '6'))
        		num[i+1] += num[i-1];
        }
        return num[s.length()];
    }
}
