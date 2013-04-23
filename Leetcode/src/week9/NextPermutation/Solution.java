/*
 * Next Permutation - Feb 25 '12 - 732 / 2094

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 ¡ú 1,3,2
3,2,1 ¡ú 1,2,3
1,1,5 ¡ú 1,5,1
 */

package week9.NextPermutation;

public class Solution {
	int[] num;
	public void nextPermutation(int[] num) {
		this.num = num;
		int start = num.length - 1;
		while(start > 0){
			if(num[start] > num[start-1]) break;
			start--;
		}
		if(start == 0) 
			reverse(0, num.length - 1);
		else {
			int i;
			for(i = num.length - 1; i >= start; i--){
				if(num[i] > num[start-1]){
					int temp = num[start-1];
					num[start-1] = num[i];
					num[i] = temp;
					reverse(start, num.length - 1);
				}
			}
		}
	}
	
	public void reverse(int i, int j){
		while(i < j){
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
			i++;
			j--;
		}
	}
}
