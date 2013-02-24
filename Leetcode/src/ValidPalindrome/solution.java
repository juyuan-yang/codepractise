/* Valid PalindromeJan 13
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome. 
*/

package ValidPalindrome;

public class solution {

	public static void main(String[] args) {
		String s = ".,";
		System.out.println(isPalindrome(s));
	}

    public static boolean isPalindrome(String s) {
        if(s == null) return true;
        if(s.length() == 0) return true;
        
        int start = 0, end = s.length() - 1;
        while(start < end){
        	while(start < s.length() && !isChar(s.charAt(start))) start++;
        	while(end >= 0 && !isChar(s.charAt(end))) end--;
        	if(start == s.length() || end == -1) return true;
        	if(!isEqual(s.charAt(start), s.charAt(end))) return false;
        	start++; 
        	end--;
        }
        
        return true;
    }
    
    public static boolean isEqual(char ch1, char ch2){
    	if(ch2 >= 'A' && ch2 <= 'Z') ch2 += ('a' - 'A');
    	if(ch1 >= 'A' && ch1 <= 'Z') ch1 += ('a' - 'A');
    	return ch1 == ch2;
    }
    
    public static boolean isChar(char ch){
    	if(ch >= '0' && ch <= '9') return true;
    	if(ch >= 'a' && ch <= 'z') return true;
    	if(ch >= 'A' && ch <= 'Z') return true;
    	return false;
    }
}
