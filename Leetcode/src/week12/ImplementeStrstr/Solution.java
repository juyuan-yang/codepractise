/*
Implement strStr() - Feb 18 '12 - 4054 / 12733
Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */

package week12.ImplementeStrstr;

public class Solution {
    // TODO: implement KMP
    public String strStr(String haystack, String needle) {
        if(haystack == null) return null;
        if(needle == null || needle.length() == 0) return haystack;

        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            int j = 0;
            for( ; j < needle.length(); j++){
                if(haystack.charAt(i+j) != needle.charAt(j)) break;
            }
            if(j == needle.length()){
                return haystack.substring(i);
            }
        }

        return null;
    }
}
