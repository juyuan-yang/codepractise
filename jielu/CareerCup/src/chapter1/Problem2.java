package chapter1;

/**
 * From Cracking the Coding Interview
 * Problem 1.2, finished on 2/23/2013
 * Write code to reverse a C-Style String.
 * (C-Style means that "abcd" is represented as five characters, including the null character.)
 * @author jielu
 *
 */
public class Problem2 {
	
	public static String reverseString(String input){
		if(input == null)
			return null;
		
		char[] inputs = input.toCharArray();
		if(inputs[0] == '\0')
			return input;
		
		for(int i=0, j=inputs.length -2; i < j; i++, j--){
			char temp = inputs[i];
			inputs[i] = inputs[j];
			inputs[j] = temp;
		}
		
		return String.valueOf(inputs);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = null;
		System.out.println(str1 + ", Reversed String: " + Problem2.reverseString(str1));

		str1 = "\0";
		System.out.println(str1 + ", Reversed String: " + Problem2.reverseString(str1));
		
		str1 = "a\0";
		System.out.println(str1 + ", Reversed String: " + Problem2.reverseString(str1));
		
		str1 = " \0";
		System.out.println(str1 + ", Reversed String: " + Problem2.reverseString(str1));
		
		str1 = "ab\0";
		System.out.println(str1 + ", Reversed String: " + Problem2.reverseString(str1));
		
		str1 = "abcde\0";
		System.out.println(str1 + ", Reversed String: " + Problem2.reverseString(str1));
		
		
	}

}
