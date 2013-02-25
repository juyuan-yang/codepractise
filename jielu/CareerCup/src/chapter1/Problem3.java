package chapter1;

/**
 * From Cracking the Coding Interview
 * Problem 1.3, finished on 2/23/2013
 * Design an algorithm and write code to remove the duplicated characters in a string
 * without using any additional buffer.
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 * @author jielu
 *
 */
public class Problem3 {
	public static String removeDuplicates(String input){
		if(input == null || input == "")
			return input;
		
		char[] inputs = input.toCharArray();
		
		if(inputs.length == 1)
			return input;
		
		int flag = 1; // Characters before index flag are all distinct
		for(int i=1; i<inputs.length && flag <inputs.length; ){
			int j = 0;
			for(; j<flag; j++){
				if(inputs[j] == inputs[i]){
					i++;
					break;
				}
			}
			if(j == flag){
				inputs[flag] = inputs[i];
				i ++;
				flag ++;
			}
			
		}
		return String.valueOf(inputs).substring(0, flag);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = null;
		System.out.println(str1 + ", RESULT: " + Problem3.removeDuplicates(str1));
		
		str1 = "";
		System.out.println(str1 + ", RESULT: " + Problem3.removeDuplicates(str1));
		
		str1 = "a";
		System.out.println(str1 + ", RESULT: " + Problem3.removeDuplicates(str1));
		
		str1 = "abcdefg";
		System.out.println(str1 + ", RESULT: " + Problem3.removeDuplicates(str1));
		
		str1 = "abbbbcedfggh";
		System.out.println(str1 + ", RESULT: " + Problem3.removeDuplicates(str1));
		
		str1 = "abbbbb";
		System.out.println(str1 + ", RESULT: " + Problem3.removeDuplicates(str1));
		

	}

}
