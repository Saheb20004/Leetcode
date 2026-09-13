/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null) return null;

        ListNode slow=head;
        ListNode fast=head;

        // Phase 1: Detect whether a cycle exists
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) { //Cycle detected
                slow = head;
                while(slow != fast){ // Phase 2: Find the starting point of the cycle
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            } 
        }
        // No Cycle
        return null;
    }
}