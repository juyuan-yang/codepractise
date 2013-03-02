package validPalindrome;

/**
 * From Leetcode online judge
 * Problem: Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example, 
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * Finished on 3/1/2013
 * @author jielu
 *
 */
public class Solution {
	public static boolean isPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(s == null || s.isEmpty())
			return true;
		
		char[] strings = s.toCharArray();
		for(int i=0, j=strings.length-1; i<j;){
			if(!isAlphanumeric(strings[i])){
				i++;
				continue;
			}

			if(!isAlphanumeric(strings[j])){
				j--;
				continue;
			}
				
			if(!isEquals(strings[i], strings[j]))
				return false;
			
			i ++;
			j --;
		}

		return true;
	}
	
	public static boolean isAlphanumeric(char c){
		return Character.isDigit(c) || Character.isLetter(c);
	}
	
	public static boolean isEquals(char a, char b){
		if(Character.isLetter(a) && Character.isLetter(b))
			return Character.toUpperCase(a) == Character.toUpperCase(b);
		
		if(Character.isDigit(a) && Character.isDigit(b))
			return a == b;
		
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "A man, a plan, a canal: Panama";
		String str2 = "race a car";
		
		System.out.println("" + Solution.isPalindrome(str1));
		System.out.println(""+ Solution.isPalindrome(str2));

	}

}
