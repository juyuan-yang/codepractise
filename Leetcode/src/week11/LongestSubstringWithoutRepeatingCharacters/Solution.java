/*
Longest Substring Without Repeating Characters - May 16 '11 - 4497 / 13524

Given a string, find the length of the longest substring without repeating characters.
For example, the longest substring without repeating letters for "abcabcbb" is "abc",
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */

package week11.LongestSubstringWithoutRepeatingCharacters;

/**
 * Created with IntelliJ IDEA.
 * User: juyuan.yang
 * Date: 6/3/13
 * Time: 8:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s != null && s.length() > 0){
            int maxCh = 1, start = 0;
            for(int i = 0; i < s.length(); i++)
                if(s.charAt(i) > maxCh) maxCh = s.charAt(i);

            int[] count = new int[maxCh + 1], pre = new int[maxCh + 1];
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if(count[ch] == 1) {
                    for(int j = start; j <= pre[ch]; j++){
                        count[s.charAt(j)]--;
                    }
                    start = pre[ch] + 1;
                }
                if(count[ch] == 0) {
                    pre[ch] = i;
                    count[ch]++;
                    if(i - start + 1> max) max = i - start + 1;
                }
            }
        }
        return max;
    }
}
