/*
 * Text Justification - Apr 3 '12 - 95 / 460
Given an array of words and a length L, format the text such that each line has exactly L characters 
and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. 
If the number of spaces on a line do not divide evenly between words, 
the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
 */

package week6.TextJustification;

import java.util.ArrayList;

public class Solution {
	// This question is not hard, but easy to make mistakes.
	// Do it again next iteration
	// Sometimes it will have Time limit exceed ....
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        
        int length, end;
        for(int i = 0; i < words.length;){
        	length = words[i].length();
        	end = i + 1;
        	// try to get as many as words in
        	while(end < words.length && length + words[end].length() + end - i <= L){
        		length += words[end++].length();
        	}
        	String ans = "";
        	if(end != words.length){ // not the last line
        		if(end == i + 1){ // only one word
        			ans = words[i] + getBlks(L - words[i].length());
        		} else { // several words
        			for(int j = i, extra = (L - length) % (end - i - 1); j < end - 1; j++){
        				ans += words[j] + getBlks((L - length) / (end - i - 1));
        				if(extra > 0){
        					ans += " ";
        					extra--;
        				}
        			}
        			ans += words[end - 1];
        		}
        	} else { // last line, don't perform left-justified
        		for(int j = i; j < end - 1; j++) ans += words[j] + " ";
        		ans += words[end - 1];
        		for(int j = ans.length(); j < L; j++) ans += " ";
        	}
        	res.add(ans);
        	i = end;
        }
        return res;
    }
    public String getBlks(int n){
    	if(n == 0) return "";
    	else if(n == 1) return " ";
    	else if(n == 2) return "  ";
    	else if(n == 3) return "   ";
    	else if(n == 4) return "    ";
    	else{
    		String s = "";
    		while(n > 0){
    			s += " ";
    			n--;
    		}
    		return s;
    	}
    }
}
