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
        // Edge Case
        if(head == null || head.next == null){
            return head;
        }
        
        ArrayList<Integer> list = new ArrayList<>();

        // Add LinkedList elements into the ArrayList
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(list);

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