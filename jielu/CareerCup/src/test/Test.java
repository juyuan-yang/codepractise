package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Test {

	public static String removeDuplicateWords(String s){
	    HashSet<String> wordsSet = new HashSet<String>();

	    char[] array = s.toCharArray();
	    StringBuilder builder = new StringBuilder();
	    int start = -1;

	    int length = array.length;
	    StringBuilder word = new StringBuilder();
	    for(int i=0; i<length; i++){
	       if(!(array[i] >= 'a' && array[i] <= 'z')){
	          builder.append(array[i]);
	          continue;
	       }

	       //word starts
	       if(start == -1 && array[i] != ' '){
	          start = i;
	          word = new StringBuilder();
	       }

	       word.append(array[i]);

	       //word ends
	       if(start != -1 && (i==length-1 || array[i+1] == ' ')){
	          String temp = word.toString();
	          if(!wordsSet.contains(temp)){
	             builder.append(temp);
	             wordsSet.add(temp);
	          }
	          start = -1;
	       }

	    }

	    return builder.toString();
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = " I like this program . this is a good like.  ";
		System.out.println(s);
		
		System.out.println(Test.removeDuplicateWords(s));
	

	}

}


