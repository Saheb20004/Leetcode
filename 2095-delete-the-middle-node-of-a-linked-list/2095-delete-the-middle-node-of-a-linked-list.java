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
    public ListNode deleteMiddle(ListNode head) {
        //Edge Case
        if(head == null || head.next == null) return null;

        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count ++;
            temp = temp.next;
        }
        
        int midNode = count/2;
        temp = head;
        while(temp != null){
            midNode -= 1;
            if(midNode == 0){
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}