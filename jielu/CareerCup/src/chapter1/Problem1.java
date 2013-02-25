package chapter1;

import java.util.HashMap;

/**
 * From Cracking the Coding Interview
 * Problem 1.1, finished on 2/23/2013
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures?
 * @author jielu
 *
 */
public class Problem1 {
	public static boolean allCharactersUnique(String input){
		HashMap mapping = new HashMap();
		char[] inputs = input.toCharArray();
		for(int i=0; i<inputs.length; i++){
			if(mapping.containsKey(inputs[i])){
				return false;
			}
			
			mapping.put(inputs[i], true);
			
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "abcd.ei1~";
		System.out.println(str1 + ", All characters unique: " + Problem1.allCharactersUnique(str1));
		
		str1 = "abacd.edi1~";
		System.out.println(str1 + ", All characters unique: " + Problem1.allCharactersUnique(str1));
		
		str1 = "abcdd.edi1~";
		System.out.println(str1 + ", All characters unique: " + Problem1.allCharactersUnique(str1));
		

	}

}
