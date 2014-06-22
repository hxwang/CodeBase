/**
 * Problem Statement: Word Ladder 
 * 
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * 
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5
 */
 
 
 /**
  * Reference
  * http://www.programcreek.com/2012/12/leetcode-word-ladder/
  */




public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        
        //BFS traversal
        
        //wordQueue: BFS add word
        LinkedList<String> wordQueue = new LinkedList<String>();
        //distanceQueue: corresponding search distance for words in wordQueue
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
        
        //initialize
        wordQueue.add(start);
        distanceQueue.add(1);
        
        //BFS traverse words
        while(!wordQueue.isEmpty()){
            
            String word = wordQueue.pop();
            int distance = distanceQueue.pop();
            
            if(word.equals(end))
                return distance;
            
            //BFS     
            for(int i=0; i<word.length(); i++){
                
                char[] currWordArray = word.toCharArray();
                
                for(char c='a'; c<='z';c++){
                    //change char
                    currWordArray[i]=c;
                    
                    //convert charArray to string
                    String newWord = new String(currWordArray);
                    //enqueue
                    if(dict.contains(newWord)){
                        wordQueue.add(newWord);
                        distanceQueue.add(distance+1);
                        //remove to avoid repeted traverse
                        dict.remove(newWord);
                    }
                 }
                 
                }
            }
            
            return 0;
        }
    }
