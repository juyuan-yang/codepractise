/*
 * https://code.google.com/codejam/contest/2270488/dashboard#s=p2
 */

package codejam15.qual.problemc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Solution {
	public int upper;
	public boolean[] quali;
	public ArrayList<Long> ans;
	
	public Solution(int upper){
		this.upper = upper;
		quali = new boolean[upper+1];
	}
	
	public Solution() {
		this.upper = 100000;
		quali = new boolean[upper+1];
	}
	
	public int getRange(int s, int e){
		int res = 0;
		for(int i = s; i <= e; i++){
			if(quali[i]) res++;
		}
		return res;
	}
	
	public void getResUndThou(){
		long sqt = (long) Math.sqrt(1e16);
		quali[1] = true;
		quali[4] = true;
		quali[9] = true;
		isPanlindrome(sqt * sqt);
		for(long i = 4; i <= sqt; i++){
			if(isPanlindrome(i) && isPanlindrome(i * i)){
				if(i*i <= upper) quali[(int) (i*i)] = true;
				System.out.println(i*i + " " + i);
			}
		}
	}
	
	public boolean isPanlindrome(long num){
		if(num <= upper && quali[(int) num]) return true;
		ArrayList<Long> bits = new ArrayList<Long>();
		
		while(num > 0){
			bits.add(num % 10);
			num /= 10;
		}
		
		for(int i = 0; i < bits.size() / 2; i++){
			if(bits.get(i) != bits.get(bits.size() - 1 - i)) 
				return false;
		}
		return true;
	}
	
	public void printAll(){
		for(int i = 0; i <= upper; i++){
			if(quali[i]) System.out.println(i + " " + (int) Math.sqrt(i));
		}
	}
	
	public void readAns(){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File("interesting.txt")));
			ans = new ArrayList<Long>();
			String s;
			
			while((s = reader.readLine()) != null){
				String[] strs = s.trim().split(" ");
				ans.add(Long.parseLong(strs[0].trim()));
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getRangeFromAns(long s, long t){
		int total = 0;
		for(int i = 0; i < ans.size(); i++){
			if(ans.get(i) >= s && ans.get(i) <= t)
				total++;
		}
			
		return total;
	}
	
	
	int[] bits = new int[51];
	int[] mul = new int[102];
	int bit;
	PrintWriter writer;
	public void tryLarge() throws Exception{
		writer = new PrintWriter(new File("haha.txt"));
		for(bit = 4; bit <= 50; bit++){
			if(bit % 2 == 0){
				bits[0] = 1;
				visit(1);
				
				for(int i = 1; i < bit - 1; i++) bits[i] = 0;
				bits[0] = bits[bit - 1] = 2;
				calMul();
			} else {
				bits[0] = 1;
				bits[bit / 2] = 0;
				visit(1);
				bits[bit / 2] = 1;
				visit(1);
				bits[bit / 2] = 2;
				visit(1);
				
				for(int i = 1; i < bit - 1; i++) bits[i] = 0;
				bits[0] = bits[bit - 1] = 2;
				calMul();
				for(int i = 1; i < bit - 1; i++) bits[i] = 0;
				bits[0] = bits[bit - 1] = 2;
				bits[bit/2] = 1;
				calMul();
			}
		}
		writer.close();
	}
	
	public void visit(int num){
		if(num == bit / 2){
			for(int i = 0; i < num; i++){
				bits[bit - 1 - i] = bits[i];
			}
			calMul();
			return;
		} else {
			bits[num] = 0;
			visit(num + 1);
			bits[num] = 1;
			visit(num + 1);
		}
	}
	
	public void calMul(){
		for(int i = 0; i < 102; i++) mul[i] = 0;
		
		for(int i = 0; i < bit; i++)
			for(int j = 0; j < bit; j++){
				mul[i + j] += bits[i] * bits[j];
			}
		for(int i = 0; i < 102; i++)
			if(mul[i] > 9){
				mul[i+1] += mul[i] / 10;
				mul[i] %= 10;
			}
		
		int num = 101;
		while(mul[num] == 0) num--;
		for(int i = 0; i <= num/2; i++)
			if(mul[i] != mul[num - i]) return;
		
		for(int i = num; i >= 0; i--){
			System.out.print(mul[i]);
			writer.print(mul[i]);
		}
		System.out.print(" ");
		writer.print(" ");
		for(int i = bit-1; i >= 0; i--){
			System.out.print(bits[i]);
			writer.print(bits[i]);
		}
		System.out.println();
		writer.println();
	}
	
	// read results for 2nd large test
	ArrayList<String> superLarge = new ArrayList<String>();
	public void readData() throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(new File("haha.txt")));
		String s;
		while((s = reader.readLine()) != null){
			String[] nums = s.trim().split(" ");
			superLarge.add(nums[0].trim());
		}
		reader.close();
		System.out.println(superLarge.size());
	}
	
	public int getRangeFromStr(String s, String t){
		int total = 0;
		for(int i = 0; i < superLarge.size(); i++){
			if(isEqual(s, superLarge.get(i)) == 1) continue;
			if(isEqual(t, superLarge.get(i)) == -1) continue;
			total++;
		}
		return total;
	}
	
	// return 0, when num1 == num2
	// return 1, when num1 > num2
	// return -1, when num1 < num2
	public int isEqual(String num1, String num2){
		if(num1.length() < num2.length()) return -1;
		else if(num1.length() > num2.length()) return 1;
		else {
			for(int i = 0; i < num1.length(); i++){
				char ch1 = num1.charAt(i), ch2 = num2.charAt(i);
				if(ch1 < ch2) return -1;
				else if(ch1 > ch2) return 1;
			}
		}
		return 0;
	}
}

/*
 * for first large test 
1 1
4 2
9 3
121 11
484 22
10201 101
12321 111
14641 121
40804 202
44944 212
1002001 1001
1234321 1111
4008004 2002
100020001 10001
102030201 10101
104060401 10201
121242121 11011
123454321 11111
125686521 11211
400080004 20002
404090404 20102
10000200001 100001
10221412201 101101
12102420121 110011
12345654321 111111
40000800004 200002
1000002000001 1000001
1002003002001 1001001
1004006004001 1002001
1020304030201 1010101
1022325232201 1011101
1024348434201 1012101
1210024200121 1100011
1212225222121 1101011
1214428244121 1102011
1232346432321 1110111
1234567654321 1111111
4000008000004 2000002
4004009004004 2001002
*/

