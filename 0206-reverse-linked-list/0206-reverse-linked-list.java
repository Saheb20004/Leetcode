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
    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        Stack<ListNode> st = new Stack<>();

        ListNode temp = head;

        // Push all nodes into stack
        while (temp != null) {
            st.push(temp);
            temp = temp.next;
        }

        // First node of reversed list
        ListNode newHead = st.pop();
        temp = newHead;

        // Connect nodes in reverse order
        while (!st.isEmpty()) {
            temp.next = st.pop();
            temp = temp.next;
        }

        // Last node must point to null
        temp.next = null;

        return newHead;
    }
}