/**
 * Problem Statement: Reverse Nodes in k-Group 
 * Link: https://oj.leetcode.com/problems/reverse-nodes-in-k-group/
 * Time: 476 ms
 * Ref: http://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html
 * hardness: *****
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 */



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        //special case
        if(head==null || k==1) return head;
        
        //setup dummyHead, pre
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        int i = 0;
        
        while(head!=null){
            i++;
            //reverse range of length k
            if(i%k==0){
                pre = reverseRange(pre, head.next);
                head = pre.next;
            }else{
                head = head.next;
            }
        }
        
        return dummyHead.next;
    }
    
    //reverse the range between pre and next pointer
    public ListNode reverseRange(ListNode pre, ListNode next){
        
        ListNode last = pre.next;
        ListNode curr = last.next;
        
        while(curr != next){
            last.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;
        }
        
        return last;
    }
}


/////////////////////////////////////////////////////////////
//Round: 1/1/2015
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null || k==1) return head;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode pre = dummyhead;
        
        int i=0;
        //traverse list, reverse every k nodes
        while(head!=null){
            i++;
            if(i%k==0){
                pre = reverseNode(pre, head.next);
                head = pre.next;
            }
            else head = head.next;
        }
        
        return dummyhead.next;
        
    }
    
    //reverse nodes between (pre, tail), return tail of the reverse string
    //which points to the head of next list
    public ListNode reverseNode(ListNode pre, ListNode tail){
        
        ListNode last = pre.next;
        ListNode curr = last.next;
        
        while(curr!=tail){
            last.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;
            
        }
        
        return last;
    }
}


//////////////////////////////////////////////////////////////
// 2015/10/29
// Highlight: revers list and pointer
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyhead = new ListNode(-1);
        ListNode curr = dummyhead;
        dummyhead.next = head;
        
        if(head==null) return head;
        
        ListNode first = head;
        ListNode second = head;
        int i = 0;
        
        while(i<k-1 && first!=null && second!=null){
            second = second.next;
            i++;
            // find k list, reverse and continue
            if(i==k-1 && second!=null){
                ListNode nextFirst = second.next;
                second.next = null;
                ListNode tail = reverseList(first);
                curr.next = second;
                tail.next = nextFirst;
                first = nextFirst;
                second = nextFirst;
                curr = tail;
                i = 0;
            }
            
        }
        
        return dummyhead.next;
       
    }
    
    // Reverse a k-list, and return tail
    public ListNode reverseList(ListNode first){
       ListNode tail = first;
       ListNode tmp1 = first.next;
       ListNode tmp2 = null;
       if(tmp1!=null){
           tmp2 = tmp1.next;
       }
       
       while(first!=null && tmp1!=null){
           tmp1.next = first;
           first = tmp1;
           tmp1 = tmp2;
           if(tmp2!=null)
            tmp2 = tmp2.next;
           else tmp2 = null;
       }
       return tail;
    }
    
    
}
