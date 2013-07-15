/*
String to Integer (atoi) - Dec 27 '11 - 2740 / 12897
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases.
If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
You are responsible to gather all the input requirements up front.
 */

/*
Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits
as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number,
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number,
or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.
If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
package week12.StringToInt;

public class Solution {
    /*
    My consideration:
    1. positive/negative number -- +/-
    2. point -- do an approximation or throw an exception
    3. overflow -- Max_Int / Min_Int, if exceeds then output Max_INT or Min_Int
    4. Other illegal char -- just ignore? if there are more numbers, throw an exception
     */
    public int atoi(String str) {
        if(str == null || str.isEmpty()) return 0;
        str = str.trim();
        str = omitChar(str);
        if(str.isEmpty()) return 0;
        
        boolean positive = true;
        if(str.charAt(0) == '-'){
        	positive = false;
        	if(smallerThanMinInt(str)) return Integer.MIN_VALUE; // will also check for equal
        	str = str.substring(1);
        } else if(str.charAt(0) == '+'){
        	str = str.substring(1);
        	if(str.isEmpty()) return 0;
        	if(biggerThanMaxInt(str)) return Integer.MAX_VALUE; // will also check for equal
        } else {
            if(biggerThanMaxInt(str)) return Integer.MAX_VALUE;
        }
        
        int res = 0;
        for(int i = 0; i < str.length(); i++){
        	res = res * 10 + str.charAt(i) - '0';
        }
        
        if(positive) return res;
        else return -res;
    }
    
    public boolean biggerThanMaxInt(String str){
    	String max = String.valueOf(Integer.MAX_VALUE);
    	if(str.length() > max.length()) return true;
    	else if(str.length() == max.length()){
    		for(int i = 0; i < max.length(); i++){
    			if(str.charAt(i) > max.charAt(i)) return true;
    			else if(str.charAt(i) < max.charAt(i)) return false;
    		}
    		return true; // equal here
    	}
    	return false;
    }
    
    public boolean smallerThanMinInt(String str){
    	String min = String.valueOf(Integer.MIN_VALUE);
    	if(str.length() > min.length()) return true;
    	else if(str.length() == min.length()){
    		for(int i = 0; i < min.length(); i++){
    			if(str.charAt(i) > min.charAt(i)) return true;
    			else if(str.charAt(i) < min.charAt(i)) return false;
    		}
    		return true; // equal here
    	}
    	return false;
    }
    
    public String omitChar(String str){
    	StringBuilder sb = new StringBuilder();
    	boolean hasOtherChar = false;
    	for(int i = 0; i < str.length(); i++){
    		if(isNum(str.charAt(i)) || (i == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')) ){
    			if(!hasOtherChar){
    				sb.append(str.charAt(i));
    			}
    		} else {
    			hasOtherChar = true;
    		}
    	}
    	return sb.toString();
    }

    public boolean isNum(char ch){
    	return ch >= '0' && ch <= '9';
    }
}
