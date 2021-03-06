/**
 * Problem Statement: Unique Binary Search Trees
 */
 
/** 
 * Reference:
 * http://fisherlei.blogspot.com/2013/03/leetcode-unique-binary-search-trees.html
 */


public class Solution {
    public int numTrees(int n) {
        
        //dynamic programming approach
        if(n==0) return 1;
        int[] count = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        
        for(int i=2; i<=n; i++){
            for(int j=0; j<i;j++)
                count[i]+=count[j]*count[i-j-1];
        }
        
        return count[n];
    }
}

//////////////////////////////////////////////////////////////////////
//Round 2: 12/16/2014
public class Solution {
    public int numTrees(int n) {
        
        int[] count = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        
        //number of ways to build n bst
        //left and right tree have multiple possibilities
        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++)
                count[i] += count[j]*count[i-j-1];
        }
        
        return count[n];
    }
}


///////////////////////////////////////////////
// 2015/11/08
// Highlight: 1D DP, 
public class Solution {
    public int numTrees(int n) {
        int[] count = new int[n+1];
        if(n==1) return 1;
        if(n==2) return 2;
        count[0] = 1;
        count[1] = 1;
        count[2] = 2;
        
        for(int i=3; i<=n; i++){
            for(int j=0; j<=i-1; j++){
                count[i] += count[j]*count[i-j-1];
            }
        }
     
        return count[n];
    }
}
