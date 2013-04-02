/*
 * Pascal's Triangle II - Oct 29 '12
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */

package week1.PascalTriangle2;

import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {

	}
    public ArrayList<Integer> getRow(int rowIndex) {
    	int[] array = new int[rowIndex + 1];
    	array[0] = 1;
    	for(int i = 1; i <= rowIndex; i++){
    		array[i] = array[i - 1];
    		for(int j = i - 1; j > 0; j--){
    			array[j] += array[j - 1];
    		}
    	}
    	
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) res.add(array[i]);
        return res;
    }
}
