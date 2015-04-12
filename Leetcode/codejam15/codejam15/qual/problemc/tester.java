package codejam15.qual.problemc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import codejam13.qual.problemc.Solution;

public class tester {
	public static void main(String[] args) {
		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File("in.txt")));
			PrintWriter writer = new PrintWriter(new File("out.txt"));
			String s = reader.readLine();
			int total = Integer.parseInt(s.trim());
			
			Solution solution = new Solution(1000000);
			
			solution.readData();
			for(int i = 0; i < total; i++){
				s = reader.readLine().trim();
				String[] nums = s.split(" ");
				int res = solution.getRangeFromStr(nums[0].trim(), nums[1].trim());
				System.out.println("Case #" + (i+1) + ": " + res);
				writer.println("Case #" + (i+1) + ": " + res);
			}
				
//			solution.readAns();
////			solution.getResUndThou();
////			solution.tryLarge();
////			solution.printAll();
//			for(int i = 0; i < total; i++){
//				s = reader.readLine().trim();
//				String[] nums = s.split(" ");
////				int res = solution.getRange(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
//				int res = solution.getRangeFromAns(Long.parseLong(nums[0]), Long.parseLong(nums[1]));
//				System.out.println("Case #" + (i+1) + ": " + res);
//				writer.println("Case #" + (i+1) + ": " + res);
//			}
			
			writer.close();
			reader.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
