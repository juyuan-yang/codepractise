/*
 * Valid Number - Apr 2 '12 - 221 / 1202
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before implementing one.
 */

package week6.ValidaNumber;

public class Solution {
	// really easy to make mistakes... Redo it next iteration...
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0) return false;
        
        boolean flt = false, exp = false;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '-' || ch == '+'){
                if(i == 0){
                    if(s.length() > 1) continue;
                    else return false;
                }
                if(s.charAt(i-1) != 'e') return false;
                if(i+1 == s.length()) return false;
                if(!isNum(s.charAt(i+1))) return false;
            } else if(ch == 'e'){
                if(exp) return false;
                else {
                    exp = true;
                    if(i == 0) return false;
                    if(!isNum(s.charAt(i-1)) && s.charAt(i-1) != '.') return false;
                    if(i+1 == s.length()) return false;
                    if(!isNumSign(s.charAt(i+1))) return false;
                }
            } else if(ch == '.'){
                if(flt || exp) return false;
                else {
                    flt = true;
                    if(i != 0 && isNum(s.charAt(i-1))) continue;
                    if(i+1 != s.length() && isNum(s.charAt(i+1))) continue;
                    return false;
                }
            } else if(!isNum(ch))
                return false;
        }
        return true;
    }
    
    public boolean isNum(char ch){
        return (ch >= '0' && ch <= '9');
    }
    
    public boolean isNumSign(char ch){
        return ch == '+' || ch == '-' || isNum(ch);
    }
}
