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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry == 1){
            int sum = 0;

            // Take value from l1
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            // Take value from l2
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            
            // Add previous carry
            sum += carry;
            // Calculate carry for next position
            carry = sum / 10;
            // Create node containing current digit
            ListNode newNode = new ListNode(sum % 10);
            temp.next = newNode;

            temp = temp.next;
        }

        return dummy.next;
    }
}