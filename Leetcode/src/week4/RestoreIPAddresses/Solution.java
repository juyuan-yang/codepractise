/*
 * Restore IP Addresses - Aug 8 '12

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) 
 */

package week4.RestoreIPAddresses;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	ArrayList<String> res;
	String s;
    public ArrayList<String> restoreIpAddresses(String s) {
        this.res = new ArrayList<String>();
        this.s = s;
        if(s.length() >= 4 && s.length() <= 12) visit("", 0, 0);
        return res;
    }
    
    public void visit(String str, int start, int dot){
    	int low = (3 - dot) * 1, high = (3 - dot) * 3;
    	for(int i = 1; i <= 3; i++){
    		if(!(start + i + low <= s.length() && start + i + high >= s.length())) continue;
    		int end = start + i;
    		String sub = s.substring(start, end);
    		if(isLegal(sub)){
    			if(dot == 2){
    				String sub2 = s.substring(end, s.length());
    				if(isLegal(sub2)){
    					res.add(str + sub + "." + sub2);
    				}
    			} else
    				visit(str + sub + ".", end, dot + 1);
    		}
    	}
    }
    
    public boolean isLegal(String str){
    	int num = Integer.parseInt(str);
    	if(num > 255) return false;
    	if(str.length() > 1 && str.charAt(0) == '0') return false;
    	return true;
    }
}
