/**
 * Problem Statement: Median of Two Sorted Arrays 
 * Ref: http://www.acmerblog.com/leetcode-median-of-two-sorted-arrays-5330.html
 * 
 */

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        
        int m = A.length;
        int n= B.length;
        int sum = m+n;
        if(sum%2==1)
            return help(A, 0, m-1, B, 0, n-1, (m+n)/2);
        else return (help(A, 0, m-1, B, 0, n-1, (m+n)/2)+help(A, 0, m-1, B, 0, n-1, (m+n)/2-1))/2;
    }
    
    //find the (k+1)-th element
    public double help(int A[], int astart, int aend, int[] B, int bstart, int bend, int k){
        
        //check A and B's length
        int alen = aend-astart+1;
        int blen = bend-bstart+1;
        
        //special case
        if(alen==0)
            return B[bstart+k];
        if(blen==0)
            return A[astart+k];
        if(k==0)
            return A[astart] < B[bstart]? A[astart]: B[bstart];
          
        //get mid
        int amid = alen*k/(alen+blen);
        int bmid = k - amid-1;
        amid = astart+amid;
        bmid = bstart+bmid;
        
        if(A[amid] > B[bmid]){
            k = k-(bmid-bstart+1);
            aend = amid;
            bstart = bmid+1;
        }
        else{
            k = k-(amid-astart+1);
            bend = bmid;
            astart = amid+1;
        }
        
        return help(A, astart, aend, B, bstart, bend, k);
    }
}


/////////////////////////////////////////////////////////
// 10/03/2015
// Time complexity: O(log(n+m))
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        //judge whether odd or even
        if((n+m)%2!=0){
            return findKthElement(nums1, nums2,0,n-1,0,m-1,(n+m)/2);
        }else{
            double result1 = findKthElement(nums1, nums2,0,n-1,0,m-1,(n+m)/2);
            double result2 = findKthElement(nums1, nums2,0,n-1,0,m-1,(n+m)/2-1);
            return (result1+result2)/2.0;
        }
    }
    
    public double findKthElement(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k){
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;
        if(len1==0) return nums2[k+start2];
        if(len2==0) return nums1[k+start1];
        
        int mid1 = len1*k/(len1+len2);
        int mid2 = k - mid1-1;
        
        mid1 = mid1+start1;
        mid2 = mid2+start2;
        
        if(k==0){
            return nums1[start1]<nums2[start2]? nums1[start1]:nums2[start2];
        }
        
        //remove parts of each array, and update k
        if(nums1[mid1]<nums2[mid2]){
            k = k-(mid1-start1)-1;
            start1 = mid1+1;
            end2 = mid2;
        }else{
            k = k-(mid2-start2)-1;
            start2 = mid2+1;
            end1 = mid1;
        }
        
        return findKthElement(nums1, nums2, start1, end1, start2, end2, k);
        
    }
}
