package chapter1;

import java.lang.reflect.Array;

/**
 * From Cracking the Coding Interview
 * Problem 1.5, finished on 2/25/2013
 * Write a method to replace all spaces in a string with '%20'.
 * @author jielu
 *
 */
public class Problem5 {
	
	public static String replaceEmptyChar(String input){	
		if(input == null)
			return input;
		
		char[] str = input.toCharArray();
		int spaceCount = 0;
		int length = str.length;
		for(int i=0; i<length; i++){
			if(str[i] == ' ')
				spaceCount ++;
		}
		
		int newLength = length + 2*spaceCount;
		char[] newStr = new char[newLength];
		System.arraycopy(str, 0, newStr, 0, length);
		int j = newLength -1;
		for(int i=length-1; i>=0; i--){
			if(newStr[i] == ' '){
				newStr[j--] = '0';
				newStr[j--] = '2';
				newStr[j--] = '%';
			}else{
				newStr[j--] = newStr[i];
			}
		}
		return String.valueOf(newStr);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = null;
		System.out.println(str + ", RESULT: " + Problem5.replaceEmptyChar(str));
		
		str = "";
		System.out.println(str + ", RESULT: " + Problem5.replaceEmptyChar(str));
		
		str = " ";
		System.out.println(str + ", RESULT: " + Problem5.replaceEmptyChar(str));
		
		str = "a b";
		System.out.println(str + ", RESULT: " + Problem5.replaceEmptyChar(str));
		
		str = " abcd    d  1 e ";
		System.out.println(str + ", RESULT: " + Problem5.replaceEmptyChar(str));

	}

}
