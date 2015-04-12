/*
 * https://code.google.com/codejam/contest/6224486/dashboard
 * 
 */

package codejam15.qual.problema;

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
				String str = reader.readLine();
				String[] inputs = str.split(" ");
				int length = Integer.parseInt(inputs[0]);
				String input = inputs[1];
				int res = 0, has = input.charAt(0) - '0';
				for (int j = 1; j <= length; j++) {
					if (has >= j) {
						has += input.charAt(j) - '0';
					} else {
						res += j - has;
						has = j + input.charAt(j) - '0';;
					}
				}
				
				System.out.println("Case #" + (i+1) + ": " + res);
				writer.println("Case #" + (i+1) + ": " + res);
			}
			
			writer.close();
			reader.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
