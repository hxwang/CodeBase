/**
 * Problem Statement:ZigZag Conversion
 * Link: https://oj.leetcode.com/problems/zigzag-conversion/
 * Ref: https://github.com/kweilin123/Leetcode/blob/master/Q%26A/java/ZigZag_Conversion.java
 * Hardness: ***
 * 
 * 
 */


public class Solution {
    public String convert(String s, int nRows) {
        
        int len = s.length();
        
        //initialize string buffer to store string in each line
        StringBuffer[] sb = new StringBuffer[nRows];
        for(int i=0; i<sb.length; i++){
            sb[i] = new StringBuffer();
        }
        
        int idx = 0;
        //travese the string s, and put the char to each line buffer
        while(idx <len){
            //down
            for(int i=0; i<nRows; i++){
                if(idx < len){
                    sb[i].append(s.charAt(idx));
                    idx++;
                }
                else break;
            }
            
            //up
            for(int i = nRows-2; i>=1; i--){
                if(idx < len){
                    sb[i].append(s.charAt(idx));
                    idx++;
                }
                else break;
            }
        }
        
        
        //cancate the output in each line
        for(int i=1; i<sb.length; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}