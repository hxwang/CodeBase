public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        int l = 0;
        int r = chars.length-1;
        
        //Note A-Z comes before a-z
        while(l <= r){
            while(l<chars.length-1 && chars[l]<='z' && chars[l]>='a')
                l++;
            while(r>0 && chars[r] >='A' && chars[r]<='Z')
                r--;
            if(l<=r){
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l++;
                r--;
            }
        }
    }
}


