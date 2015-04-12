package codejam13.qual.problemd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://code.google.com/codejam/contest/2270488/dashboard#s=p3
public class Solution {
	int[] keys;
	boolean[] chest;
	Map<Integer, List<Integer>> chest2key;
	int[] key4Chest;
	int N;
	boolean found;
	int[] trace;
	String ans;
	int totalKey;
	
	public void process(File file) throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		int T = Integer.parseInt(reader.readLine().trim());
		PrintWriter writer = new PrintWriter(new File("out.txt"));
		
		for(int i = 0; i < T; i++){
			init();
			String[] nums = reader.readLine().trim().split(" ");
			N = Integer.parseInt(nums[1].trim());
			
			String[] ks = reader.readLine().trim().split(" ");
			for(String k : ks){
				keys[Integer.parseInt(k.trim())] ++;
				totalKey++;
			}
			
			for(int j = 1; j <= N; j++){
				String[] data = reader.readLine().trim().split(" ");
				key4Chest[j] = Integer.parseInt(data[0].trim());
				int size = Integer.parseInt(data[1].trim());
				List<Integer> list = new ArrayList<Integer>();
				for(int t = 0; t < size; t++){
					list.add(Integer.parseInt(data[2 + t].trim()));
				}
				chest2key.put(j, list);
			}
			
			visit(0);
			if(found){
				System.out.println("Case #" + (i+1) + ": " + ans);
				writer.println("Case #" + (i+1) + ": " + ans);;
			} else {
				System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
				writer.println("Case #" + (i+1) + ": IMPOSSIBLE");
			}
//			writer.println("Case #" + (i+1) + ": " + res);
		}
		writer.close();
	}
	
	public void visit(int num){
		if(found) return;
		if(totalKey == 0) return;
		if(num == N){
			found = true;
			for(int i = 1; i < N; i++){
//				System.out.print(trace[i] + " ");
				ans += trace[i] + " ";
			}
//			System.out.println(trace[N]);
			ans += trace[N];
			return;
		}
		System.out.println(num);
		num++;
		for(int i = 1; i <= N; i++){
			if(!chest[i] && keys[key4Chest[i]] > 0){
				keys[key4Chest[i]] --;
				totalKey--;
				chest[i] = true;
				for(int j : chest2key.get(i)){
					keys[j]++;
					totalKey++;
				}
				trace[num] = i;
				visit(num);
				keys[key4Chest[i]] ++;
				totalKey++;
				chest[i] = false;
				for(int j : chest2key.get(i)){
					keys[j]--;
					totalKey--;
				}
			}
		}
	}
	
	public void init() {
		keys = new int[401];
		chest = new boolean[201];
		chest2key = new HashMap<Integer, List<Integer>>();
		key4Chest = new int[201];
		found = false;
		trace = new int[201];
		ans = "";
		totalKey = 0;
	}
}
