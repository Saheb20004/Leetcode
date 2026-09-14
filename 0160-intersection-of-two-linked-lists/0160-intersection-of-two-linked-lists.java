/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Only check if the heads themselves are null
        if (headA == null || headB == null) {
            return null;
        }
        
        Map<ListNode, Integer> map = new HashMap<>();

         // Store every node of list A into a HashMap named map
        ListNode temp = headA;
        while(temp != null){
            map.put(temp,1);
            temp = temp.next;
        }

        temp = headB; // Traverse list B
        while(temp != null){
            if(map.containsKey(temp)){ // Same node object found
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }
}