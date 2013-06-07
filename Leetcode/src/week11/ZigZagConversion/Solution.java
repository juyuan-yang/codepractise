/*
ZigZag Conversion - Dec 6 '11 - 2641 / 7668

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

package week11.ZigZagConversion;

/**
 * Created with IntelliJ IDEA.
 * User: juyuan.yang
 * Date: 6/6/13
 * Time: 11:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public String convert(String s, int nRows) {
        if(s == null || s.length() == 0) return "";
        if(nRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        if(nRows == 2) {
            for(int i = 0; i < s.length(); i += 2) sb.append(s.charAt(i));
            for(int i = 1; i < s.length(); i += 2) sb.append(s.charAt(i));
        } else {
            int m = (s.length() / (nRows + nRows - 2) + 1) * 2 + 1;
            char[][] chs = new char[nRows][m];
            boolean[][] used = new boolean[nRows][m];
            int col = 0, row = 0;
            for(int i = 0; i < s.length(); i++){
                chs[row][col] = s.charAt(i);
                used[row][col] = true;
                if(col % 2 == 0) {
                    row++;
                    if(row == nRows){
                        row = nRows - 2;
                        col++;
                    }
                } else {
                    row--;
                    if(row == 0){
                        col++;
                    }
                }
            }
            for(int i = 0; i < nRows; i++)
                for(int j = 0; j < m; j++){
                    if(used[i][j]) sb.append(chs[i][j]);
                }
        }
        return sb.toString();
    }
}
