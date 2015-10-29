/**
 * Problem Statement: Remove Duplicates from Sorted Array
 * Link: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */


public class Solution {
    public int removeDuplicates(int[] A) {
        
        if(A==null) return 0;
        if(A.length==0 || A.length==1) return A.length;
        int indx = 0;
        int newIndx = 0;
        
        //put the remain number in the right indx position
        while(indx<A.length){
            int curr = A[indx];
            //skip repete number
            while(indx+1<A.length){
                if(A[indx+1]!=curr) break;
                indx++;
            }

            A[newIndx] = curr;
            newIndx++; indx++;
        }
        
        return newIndx;
    }
}


/////////////////////////////////////////////////////
//Round 2: 1/1/2015
public class Solution {
    public int removeDuplicates(int[] A) {
        
        if(A.length==0) return 0;
        int index = 1;
        for(int i=1; i<A.length; ){
    
            if(A[i]!=A[i-1]){
                A[index] = A[i];
                index++;
                i++;
            }
            //skip all duplicates
            else{
                int num = A[i-1];
                while(i<A.length && A[i]==num)
                    i++;
            }
        }
        
        return index;
    }
}


/////////////////////////////////////////////////////////////
// 2015/10/29
// Highlight: logic
public class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        if(nums==null || nums.length==0) return 0;
        int lastNum = nums[0];
        int i=0;
        while(i<nums.length){
            //write last value when meet new value
            if(lastNum!=nums[i]){
                nums[idx] = lastNum;
                lastNum = nums[i];
                idx++;
            }
            //write last value in the array
            if(i==nums.length-1){
                nums[idx] = nums[i];
                idx++;
            }
            i++;
        }
        
        return idx;
    }
}
