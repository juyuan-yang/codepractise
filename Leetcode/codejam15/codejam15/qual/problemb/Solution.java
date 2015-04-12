/*
 * https://code.google.com/codejam/contest/6224486/dashboard
 * 
 */

package codejam15.qual.problemb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) {
		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File("in.txt")));
			PrintWriter writer = new PrintWriter(new File("out.txt"));
			String s = reader.readLine();
			int total = Integer.parseInt(s.trim());
			for(int i = 0; i < total; i++){
				s = reader.readLine();
				int length = Integer.parseInt(s.trim());
				s = reader.readLine();
				String[] nums = s.split(" ");
				LinkedList<Integer> p = new LinkedList<Integer>();
				for (int j = 0; j < length; j++) {
					int temp = Integer.parseInt(nums[j]);
					p.add(temp);
				}				
				int res = solve(p, 0);
				System.out.println("Case #" + (i+1) + ": " + res);
				writer.println("Case #" + (i+1) + ": " + res);
			}
			
			writer.close();
			reader.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static int solve(LinkedList<Integer> p, int times) {
		reverseSort(p);
		int first = p.getFirst();
		if (first < times) return first;
		if (first < 4) return first;
		else {
			int min = first;
			for (int i = 3; i <= first / 2; i++) {
				LinkedList<Integer> newP = new LinkedList<Integer>();
				newP.addAll(p);
				reverseSort(newP);
				newP.remove(0);
				newP.add(i);
				newP.add(first - i);
				int temp = solve(newP, times + 1) + 1;
				if (temp < min) min = temp;
			}
			return min;
		}
	}
	
	private static void reverseSort(LinkedList<Integer> p) {
		Comparator comparator = Collections.reverseOrder();
		Collections.sort(p, comparator);
	}
	
	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	private static int min(int a, int b) {
		return (a < b) ? a : b;
	}
}
