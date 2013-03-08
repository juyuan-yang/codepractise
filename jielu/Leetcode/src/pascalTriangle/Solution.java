package pascalTriangle;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * From Leetcode online judge Problem: Pascal's Triangle Given numRows, generate
 * the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 Finished on 3/7/2013
 */
public class Solution {
	//God Mie's alg looks more elegant
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(numRows > 0){
			ArrayList<Integer> firstRow = new ArrayList<Integer>();
			firstRow.add(1);
			result.add(firstRow);
			
			int[] row = new int[numRows];
			row[0] = 1;
			for(int i=1; i<numRows; i++){
				row[i] = row[i-1];
				
				for(int j=i-1; j>0; j--){
					row[j] += row[j-1];
				}
				
				ArrayList<Integer> newRow = new ArrayList<Integer>();
				for(int j=0; j<=i; j++){
					newRow.add(row[j]);
				}
				result.add(newRow);
			}
		}
		
		return result;
	}
	
//	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
//		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//
//		if (numRows > 0) {
//			// Initialize each row and fill the first number for each row to 1
//			ArrayList<Integer> firstRow = new ArrayList<Integer>();
//			firstRow.add(1);
//			result.add(firstRow);
//
//			for (int i = 1; i < numRows; i++) {
//				// For each row, fill the first half of it by computing the sum
//				Integer[] row = new Integer[i+1];
//				row[0] = 1;
//				
//				ArrayList<Integer> lastRow = result.get(i - 1);
//				int mid = (i+1)%2 == 0 ? (i+1)/2 -1 : (i+1)/2;
//				for (int j = 1; j <= mid ; j++) {
//					int oprand1 = lastRow.get(j - 1);
//					int oprand2 = lastRow.get(j);
//					int sum = oprand1 + oprand2;
//					row[j] = sum;
//					row[i-j] = sum;
//				}
//				
//				row[i] = 1;
//				result.add(new ArrayList<Integer>(Arrays.asList(row)));
//			}
//
//		}
//
//		return result;
//
//	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution.generate(5);

	}

}
