/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Edge Case
        if(head == null) return null;

        ListNode tail = head;
        int len = 1;

        // Find the last node & the length
        while(tail.next != null){
            len ++;
            tail = tail.next;
        }

        if(k % len == 0) return head; // Edge Case

        k = k % len;
        tail.next = head;

        ListNode newTail = head;
        for(int i=1; i < len-k; i++){
            newTail = newTail.next;
        }
        
        head = newTail.next;
        newTail.next = null;

        return head;
    }
}