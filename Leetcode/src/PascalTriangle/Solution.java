/*
 * Pascal's Triangle - Oct 28 '12
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * [
 *    [1],
 *   [1,1],
 *  [1,2,1],
 * [1,3,3,1],
 *[1,4,6,4,1]
 * ]
 */

package PascalTriangle;

import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {

	}
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(numRows == 0) return res;
    	int[] array = new int[numRows];
    	array[0] = 1;
    	ArrayList<Integer> row1 = new ArrayList<Integer>();
    	row1.add(1);
    	res.add(row1);
    	
    	for(int i = 1; i < numRows; i++){
    		array[i] = array[i - 1];
    		for(int j = i - 1; j > 0; j--){
    			array[j] += array[j - 1];
    		}
    		ArrayList<Integer> row = new ArrayList<Integer>();
    		for(int j = 0; j <= i; j++){
    			row.add(array[j]);
    		}
    		res.add(row);
    	}
        return res;
    }
}
