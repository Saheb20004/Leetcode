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

         // Traverse list A
        int countA = 0;
        ListNode tempA = headA;
        while(tempA != null){
            countA ++;
            tempA = tempA.next;
        }

        // Traverse list B
        int countB = 0;
        ListNode tempB = headB; 
        while(tempB != null){
            countB ++;
            tempB = tempB.next;
        }

        if(countA < countB){
            return collisionPoint(headA, headB, countB-countA);
        }
        else{
            return collisionPoint(headB, headA, countA-countB);
        }
    }

    private ListNode collisionPoint(ListNode tempA, ListNode tempB, int d){ 
        // d -> tempB - tempA
        while(d > 0){
            d --;
            tempB = tempB.next;
        }

        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}