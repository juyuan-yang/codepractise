package chapter1;

import java.util.Arrays;

/**
 * From Cracking the Coding Interview
 * Problem 1.4, finished on 2/23/2013
 * Write a method to decide if two strings are anagrams or not
 * @author jielu
 *
 */
public class Problem4 {
	public static boolean areAnagrams(String str1, String str2){
		if(str1 == str2)
			return true;
		
		if((str1 == null && str2 != null) || (str1 != null && str2 == null))
			return false;
		
		char[] array1 = str1.toCharArray();
		char[] array2 = str2.toCharArray();
		if(array1.length != array2.length)
			return false;
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		//return String.valueOf(array1).equals(String.valueOf(array2));
		return Arrays.equals(array1, array2);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = null;
		String str2 = null;
		System.out.println(str1 + ", " + str2 + ", " + Problem4.areAnagrams(str1, str2));
		
		str1 = null;
	    str2 = "";
		System.out.println(str1 + ", " + str2 + ", " + Problem4.areAnagrams(str1, str2));
		
		str1 = "abc";
	    str2 = "b";
		System.out.println(str1 + ", " + str2 + ", " + Problem4.areAnagrams(str1, str2));
		
		str1 = "";
	    str2 = "";
		System.out.println(str1 + ", " + str2 + ", " + Problem4.areAnagrams(str1, str2));
		
		str1 = "abcd";
	    str2 = "abcd";
		System.out.println(str1 + ", " + str2 + ", " + Problem4.areAnagrams(str1, str2));
		
		str1 = "abcdefg";
	    str2 = "efabcdg";
		System.out.println(str1 + ", " + str2 + ", " + Problem4.areAnagrams(str1, str2));
		
		str1 = "abcde";
	    str2 = "acdfe";
		System.out.println(str1 + ", " + str2 + ", " + Problem4.areAnagrams(str1, str2));

	}

}
