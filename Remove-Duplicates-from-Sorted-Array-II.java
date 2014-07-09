/**
 * Problem Statement: Remove Duplicates from Sorted Array II 
 * 
 * What if duplicates are allowed at most twice?
 */
 
 /**
  * Link: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
  */


public class Solution {
    public int removeDuplicates(int[] A) {
        
        if(A.length==0) return 0;
        
        int lastVal = A[0];
        //indicate first appearance, if false
        boolean flag = false;
        //keep writing index, update A in place
        int index = 1;
        //keep delete account
        int count = 0;
        
        for(int i=1; i<A.length; i++){
            
            //Case 1: appear more than twice
            if(A[i]==lastVal && flag){
                count++;
                continue;
            }
            
            //Case 2:appear twice
            if(A[i]==lastVal && !flag){
                flag = true;
                A[index] = A[i];
                index++;
            }
            //Case 3: first appear
            else if(A[i]!=lastVal){
                lastVal = A[i];
                flag = false;
                A[index] = A[i];
                index++;
            }
        }
        
        
        
        return A.length-count;
            
        }
    }
