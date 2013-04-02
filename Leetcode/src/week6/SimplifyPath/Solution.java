/*
 * Simplify Path - Apr 4 '12
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 */

package week6.SimplifyPath;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        if(path == null) return "";
        String[] strs = path.split("/");
        Stack<String> res = new Stack<String>();
        
        for(String s : strs){
        	if(s != null && s.length() > 0){
        		if(s.equals(".")) continue;
        		else if(s.equals("..")) {
        			if(!res.isEmpty()) res.pop();
        		} else {
        			res.push(s);
        		}
        	}
        }
        
        String ans = (res.isEmpty()) ? "" : res.pop();
        while(!res.isEmpty()){
        	ans = res.pop() + "/" + ans;
        }
        return "/" + ans;
    }
}
