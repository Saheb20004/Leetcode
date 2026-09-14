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
    public ListNode oddEvenList(ListNode head) {

        // Edge Case
        if(head == null || head.next == null){
            return head;
        }
        
        ArrayList<Integer> list = new ArrayList<>();

        // Add odd index elements into the list
        ListNode temp = head;
        while(temp != null && temp.next != null){
            list.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null)    list.add(temp.val);

        // Add even index elements into the list
        temp = head.next;
        while(temp != null && temp.next != null){
            list.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null)    list.add(temp.val);

        // Replace the node values with the stored list values
        int i=0;
        temp = head;
        while(temp != null){
            temp.val = list.get(i++);
            temp = temp.next;
        }

        return head;
    }
}