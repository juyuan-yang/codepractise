public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        int length = 0;
        if(strs != null && strs.length > 0){
            int min = 0;
            for(int i = 1; i < strs.length; i++){
                if(strs[i].length() < strs[min].length()){
                    min = i;
                }
            }
            
            res = strs[min];
            strs[min] = strs[0];
            length = res.length();
            for(int i = 1; i < strs.length; i++){
                for(int j = 0; j < res.length(); j++){
                    if(j == strs[i].length()){
                        length = j;
                        break;
                    } else if(res.charAt(j) != strs[i].charAt(j)){
                        length = j;
                        break;
                    }
                }
            }
        }
        return res.substring(0, length);
    }
}
