/*
 * http://leetcode.com/onlinejudge
 * Two Sum - Mar 14 '11
 * Given an array of integers, find two numbers such that they add up to a specific target number. 
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. 
 * 
 * Please note that your returned answers (both index1 and index2) are not zero-based. 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
package week0.twosum;

public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{3,2,1,4,5};
		int[] res = twoSum(array, 8);
		for(int i = 0; i < res.length; i++){
			System.out.print(res[i] + " ");
		}
	}

    public static int[] twoSum(int[] numbers, int target) {
    	int[] index = new int[numbers.length];
    	for(int i = 0; i < numbers.length; i++) index[i] = i + 1;
    	quicksort(numbers, 0, numbers.length - 1, index);
    	
    	int start = 0, end = numbers.length - 1;
    	while(start < end){
    		if(numbers[start] + numbers[end] == target){
    			int[] result;
    			if(index[start] < index[end]){
    				result = new int[]{index[start], index[end]};
    			} else {
    				result = new int[]{index[end], index[start]};
    			}
    			return result;
    		} else if(numbers[start] + numbers[end] < target){
    			start++;
    		} else {
    			end--;
    		}
    	}
//    	for(int i = 0; i < numbers.length; i++)
//			System.out.print(numbers[i] + " ");
//		System.out.println();
//		for(int i = 0; i < index.length; i++)
//			System.out.print(index[i] + " ");
        return null;
    }
    
    public static void quicksort(int[] nums, int s, int t, int[] pos){
    	int i = s, j = t;
    	int temp = nums[s], prepos = pos[s];
    	while(i < j){
    		while(i < j && temp < nums[j]) j--;
    		if(i < j){
    			nums[i] = nums[j];
    			pos[i++] = pos[j];
    		}
    		while(i < j && temp > nums[i]) i++;
    		if(i < j){
    			nums[j] = nums[i];
    			pos[j--] = pos[i];
    		}
    	}
    	nums[i] = temp;
    	pos[i] = prepos;
    	if(s < i - 1) quicksort(nums, s, i - 1, pos);
    	if(i + 1 < t) quicksort(nums, i + 1, t, pos);
    	
    }
}
