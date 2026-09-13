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

        Stack<Integer> st = new Stack<>();

        ListNode temp = head;

        // Push all nodes into stack
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;

        // Connect nodes in reverse order
        while (temp != null) {
            temp.val = st.pop();
            temp = temp.next;
        }
        return head;
    }
}