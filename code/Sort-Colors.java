/**
 * Problem Statement: Sort Colors 
 * Link: https://oj.leetcode.com/problems/sort-colors/
 * 
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */


public class Solution {
    public void sortColors(int[] A) {
        
        //first traverse, get the number of each color
        int color0 = 0;
        int color1 = 0;
        int color2 = 0;
        for(int i=0; i<A.length; i++){
            if(A[i]==0)
                color0++;
            else if(A[i]==1)
                color1++;
            else if(A[i]==2)
                color2++;
        }
        
        //assign value 
        for(int i=0; i<color0; i++){
            A[i] = 0;
        }
        for(int i=color0; i<color0+color1; i++){
            A[i] = 1;
        }
        for(int i=color0+color1; i<color0+color1+color2; i++){
            A[i]=2;
        }
    }
}

///////////////////////////////////////////////////////////////
//Round 2: 12/22/2014
public class Solution {
    public void sortColors(int[] A) {
        int red = 0;
        int white = 0;
        int blue = 0;
        
        //count the number of times of appearance of red, white, blue respectively
        for(int i=0; i<A.length; i++){
            if(A[i]==0) red++;
            if(A[i]==1) white++;
            if(A[i]==2) blue++;
        }
        
        for(int i=0; i<red; i++)
            A[i] = 0;
        for(int i=red; i<red+white; i++)
            A[i] = 1;
        for(int i=red+white; i<red+white+blue; i++)
            A[i] = 2;
    }
}

/////////////////////////////////////////////////////
// 2015/11/07
// Highlight: in place exchange
public class Solution {
    public void sortColors(int[] nums) {
        
        int end = nums.length-1;
        int start = 0;
        //put 0 in the first part of the array
        start = help(nums, start, end, 0);
        //put 1 in second part
        help(nums, start, end, 1);
    }
    
    //in place clean array to put target value in the first part of the array
    public int help(int[] nums, int start, int end, int target){
         int i = start;
         for(; i<nums.length && i<end; i++){
            if(nums[i]==target) continue;
            else{
                while(nums[end]!=target && end>i){
                    end--;
                }
                if(i!=end){

                    nums[end] = nums[i];
                    nums[i] = target;
                }else break;
            }
        }
        return i;
    }
}
