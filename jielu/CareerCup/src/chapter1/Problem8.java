package chapter1;

/**
 * From Cracking the code interview
 * Problem 1.8: Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
 * (i.e. "waterbottle" is a rotation of "erbottlewat"
 * Finished on 3/2/2013
 * @author jielu
 *
 */
public class Problem8 {
	public static boolean isRotation(String str1, String str2){
		int length = str1.length();
		if(str2.length() == length && length > 0){
			String str1str1 = str1 + str1;
			return isSubstring(str1str1, str2);
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
