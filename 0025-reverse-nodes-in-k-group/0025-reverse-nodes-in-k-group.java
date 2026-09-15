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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head; // temp -> beginning of the current group
        ListNode nextNode = null; // nextNode -> the first node of the next group
        ListNode prevNode = null; // prevNode -> last node of the previously reversed group

        while(temp != null){
            ListNode kthNode = findKthNode(temp, k);
            // If fewer than k nodes are left, leave them as they are and stop
            if(kthNode == null){
                if(prevNode != null)
                    prevNode.next = temp;
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;

            reverseList(temp);
            // If this is the first group, kthNode becomes the new head
            if(temp == head){
                head = kthNode;
            }
            // Connect the previous reversed group to the current reversed group
            else{
                prevNode.next = kthNode;
            }
            prevNode = temp;

            temp = nextNode;
        }
        return head;
    }

    // Returns the kth node starting from 'temp'
    private ListNode findKthNode(ListNode temp,int k){
        for(int i=1;i<k;i++){
            // If there are fewer than k nodes or kth node does not exist
            if (temp == null)
                return null;

            temp = temp.next;
        }
        return temp;
    }

    // Reverses a linked list and returns the new head
    private ListNode reverseList(ListNode head) {
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