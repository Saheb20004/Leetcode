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

    public ListNode sortList(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode mid = findMid(head);

        // Split the list
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;

        // Sort both halves
        ListNode left = sortList(leftHead);
        ListNode right = sortList(rightHead);

        // Merge
        return merge(left, right);
    }

    // Finds the last node of the left half
    private ListNode findMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge two sorted linked lists
    private ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (left != null && right != null) {

            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } 
            else {
                temp.next = right;
                right = right.next;
            }

            temp = temp.next;
        }

        if (left != null) {
            temp.next = left;
        } 
        else {
            temp.next = right;
        }

        return dummy.next;
    }
}