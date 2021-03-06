/**
 * Problem Statement: Longest Consecutive Sequence 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * 
 */

public class Solution {
    
    public int longestConsecutive(int[] num) {
        
        //use hashset to contain all elements
        HashSet<Integer> hs = new HashSet<Integer>();
        int max = 0;
        
        //put elements into hashset
        for(int i=0; i<num.length; i++)
            hs.add(num[i]);
            
        for(int i=0; i<num.length; i++){
            
            //check the longest consecutive sequence [...num[i]...]
            if(hs.contains(num[i])){
                int count = 1;
                int next = num[i]-1;
                //consecutive sequence less than num[i]
                while(hs.contains(next)){
                    //remove elements that has been visited
                    //note this is an important trick, since element which has been visted can never be in a longer sequence
                    //when traverse other num[i]
                    hs.remove(next);
                    count++;
                    next--;
                }
                
                //consecutive sequence large than num[i] 
                next = num[i]+1;
                while(hs.contains(next)){
                    hs.remove(next);
                    count++;
                    next++;
                }
                
                //calculate global max
                max = Math.max(count,max);
                
            }
        }
        
        return max;
    }
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/03/2014
//time complexity O(n)


public class Solution {
    public int longestConsecutive(int[] num) {
        
        //use hashmap to track each element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<num.length; i++)
            map.put(num[i],i);
           
        //use an array to keep track of whether the ith element is visited 
        int[] visited = new int[num.length];
        int maxLen = 0;
        
        for(int i=0; i<num.length; i++){
            if(visited[i]==1) continue;
            visited[i] = 0;
            int len = 1;
            int value = num[i] - 1;
            
            //look downside
            while(map.containsKey(value)){
                len++;
                visited[map.get(value)] =1;
                value--;
            }
            
            //look upside
            value = num[i] + 1;
            while( map.containsKey(value)){
                len++;
                visited[map.get(value)] = 1;
                value++;
            }
            
            //update result
            maxLen = maxLen > len? maxLen: len;
        }
        
        return maxLen;
    }
}






///////////////////////////////////////////////
//2015/11/16
// Highlight: amorized cost O(n)
public class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        int max = 0;
        //for each value
        for(int i=0; i<nums.length; i++){
            //if not removed yet
            //check its continous numbers
            if(set.contains(nums[i])){
                int curr = 1;
                int val = nums[i];
                set.remove(val);
                int increaseVal = val;
                while(set.contains(increaseVal+1)){
                    curr++;
                    increaseVal++;
                    set.remove(increaseVal);
                }
                while(set.contains(val-1)){
                    curr++;
                    val--;
                    set.remove(val);
                }
                if(curr>max) max = curr;
            }
        }

        return max;
    }
}
