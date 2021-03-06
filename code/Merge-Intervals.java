/**
 * Problem Statement: Merge Intervals
 * Time:
 * Link: https://oj.leetcode.com/problems/merge-intervals/
 * Ref: http://www.programcreek.com/2012/12/leetcode-merge-intervals/
 * 
 */


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        
        //special case
        if(intervals==null || intervals.size() <= 1)
            return intervals;
        //sort interval list using comparator
        Collections.sort(intervals, new IntervalComparator());
        ArrayList<Interval> rnt = new ArrayList<Interval>();
        
        //traverse the sorted interval list to check merge condition
        Interval prev = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            //merge
            if(curr.start <= prev.end){
                Interval newInterval = new Interval(prev.start, Math.max(prev.end, curr.end));
                prev = newInterval;
            }
            //not merge, so prev can be added to result
            else{
                rnt.add(prev);
                prev = curr;
            }
        }
        
        //note this step is easy to forget
        rnt.add(prev);
        
        return rnt;
    }
    
    //comparator: sort intervals in increasing order of start time
    class IntervalComparator implements Comparator<Interval>{
        
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    }
}

/////////////////////////////////////////////////////////////////////
//Round 2; 12/29/2014
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        //special case
        if(intervals.size()<=1) return intervals;
        
        //sort intervals
        Collections.sort(intervals, new ComparatorIntervel());
        
        //define return
        ArrayList<Interval> rnt = new ArrayList<Interval>();
        Interval curr = intervals.get(0);
        
        //merge intervals
        for(int i=1; i<intervals.size(); i++){
            Interval next = intervals.get(i);
            if(curr.end < next.start){
                rnt.add(curr);
                curr = next;
            }
            else{
                curr.end = Math.max(curr.end, next.end);
            }
        }
        
        rnt.add(curr);
        return rnt;
    }
    
    //comparator: sort intervals in non-decreasing order of interval start
    public class ComparatorIntervel implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
           return a.start - b.start;
        }
    }
}


//////////////////////////////////////////////////////////////////
//2015/11/05
// Highlight: comparator
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals){
        Collections.sort(intervals, new IntervalComparator());
        
        ArrayList<Interval> rnt = new ArrayList<Interval>();
        
        if(intervals.size()==0) return rnt;
        
        //merge intervals one by one
        Interval v1 = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval v2 = intervals.get(i);
            if(v1.end<v2.start){
                rnt.add(v1);
                v1 = v2;
            }else if(v1.end >= v2.end){
                Interval newInterval = new Interval(v1.start, v1.end);
                v1 = newInterval;
            }else{
                Interval newInterval = new Interval(v1.start, v2.end);
                v1 = newInterval;
            }
        }
        rnt.add(v1);
        return rnt;
    }
    
    //implement comparator
    public class IntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval v1, Interval v2){
            if(v1.start!=v2.start){
                return v1.start-v2.start;
            }else
                return v1.end-v2.end;
        }
    }
}

