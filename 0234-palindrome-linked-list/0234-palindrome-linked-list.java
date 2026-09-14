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
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        // Finding the middle of the LL & divide the LL into two halves
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half only
        ListNode newHead = reverseLL(slow.next);
        ListNode first = head;
        ListNode second = newHead;
        while(second != null){
            if(first.val != second.val){
                reverseLL(newHead); // Re-reverse the 2nd half before returning 
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseLL(newHead); // Re-reverse the 2nd half before returning
        return true;
    }

    // Iterative approach for reversing a LL
    public ListNode reverseLL(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}