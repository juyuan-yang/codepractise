package pascalTriangle2;

import java.util.ArrayList;

/**
 * From Leetcode online judge
 * Problem: Pascal's Triangle II
 * Given an index k, return the kth row of the Pascal's triangle.
For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
Finished on 3/7/2013
*/
public class Solution {
	public static ArrayList<Integer> getRow(int rowIndex) {
		int[] row = new int[rowIndex + 1];
		row[0] = 1;
		
		for(int i=1; i<=rowIndex; i++){
			row[i] = row[i-1];
			
			for(int j=i-1; j>0; j--){
				row[j] += row[j-1];
			}
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<=rowIndex; i++){
			result.add(row[i]);
		}
		

		return result;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution.getRow(4);

	}

}
