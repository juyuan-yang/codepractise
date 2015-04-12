/*
 * https://code.google.com/codejam/contest/6224486/dashboard#s=p3
 * 
 */

package codejam15.qual.problemd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class Solution {
	public static void main(String[] args) {
		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File("in.txt")));
			PrintWriter writer = new PrintWriter(new File("out.txt"));
			String s = reader.readLine();
			int total = Integer.parseInt(s.trim());
			for(int i = 0; i < total; i++){
				s = reader.readLine();
				String[] nums = s.split(" ");
				int x = Integer.parseInt(nums[0]);
				int r = Integer.parseInt(nums[1]);
				int c = Integer.parseInt(nums[2]);
				boolean res = true;
				int n1 = min(r, c), n2 = max(r, c);
				switch (x) {
				case 1:
					res = false;
					break;
				case 2:
					if ((n1 * n2) % 2 == 0) res = false;
					break;
				case 3:
					if (n1 == 2 && n2 == 3) res = false;
					if (n1 == 3 && n2 == 3) res = false;
					if (n1 == 3 && n2 == 4) res = false;
					break;
				case 4:
					if (n1 == 3 && n2 == 4) res = false;
					if (n1 == 4 && n2 == 4) res = false;
					break;
				}
				System.out.println("Case #" + (i+1) + ": " + (res ? "RICHARD" : "GABRIEL"));
				writer.println("Case #" + (i+1) + ": " + (res ? "RICHARD" : "GABRIEL"));
			}
			
			writer.close();
			reader.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	private static int min(int a, int b) {
		return (a < b) ? a : b;
	}
}
