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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 0;
        ListNode temp = head;

        // Count nodes
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Remove head
        if (count == n) {
            return head.next;
        }

        // Move to node before the target
        temp = head;

        for (int i = 1; i < count - n; i++) {
            temp = temp.next;
        }

        // Remove target node
        temp.next = temp.next.next;

        return head;
    }
}