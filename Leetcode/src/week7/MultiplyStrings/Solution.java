/*
 * Multiply Strings - Mar 12 '12 - 350 / 1455

Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 */

package week7.MultiplyStrings;

public class Solution {
	public String multiply(String num1, String num2) {
		if(num1.length() == 0 || num2.length() == 0) return "";
		int[] n1, n2, res;
		n1 = new int[(num1.length() + 3) / 4];
		n2 = new int[(num2.length() + 3) / 4];
		res = new int[(num1.length() + 3) / 4 + (num2.length() + 3) / 4 + 1];
		
		int l1 = 0, l2 = 0, temp;
		for(int i = num1.length(); i > 0; i = i - 4){
			n1[l1++] = Integer.parseInt(num1.substring(getMax(0, i - 4), i));
		}
		for(int i = num2.length(); i > 0; i = i - 4){
			n2[l2++] = Integer.parseInt(num2.substring(getMax(0, i - 4), i));
		}
		
		for(int i = 0; i < l1; i++){
			for(int j = 0; j < l2; j++){
				res[i+j] += n1[i] * n2[j];
				temp = i + j;
				while(res[temp] > 9999){
					res[temp+1] += res[temp] / 10000;
					res[temp++] %= 10000;
				}
			}
		}
		
		StringBuilder ans = new StringBuilder();
		temp = (num1.length() + 3) / 4 + (num2.length() + 3) / 4;
		while(res[temp] == 0 && temp > 0) temp--;
		ans.append(res[temp]);
		for(int i = temp - 1; i >= 0; i--){
			if(res[i] < 1000) ans.append("0");
			if(res[i] < 100) ans.append("0");
			if(res[i] < 10) ans.append("0");
			ans.append(res[i]);
		}
		return ans.toString();
	}
	
	public int getMax(int num1, int num2){
		return (num1 > num2) ? num1 : num2;
	}
}
