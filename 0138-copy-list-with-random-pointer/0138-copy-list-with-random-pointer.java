/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {
        // Edge Case
        if (head == null) return null;

        // Step 1: Create and interleave copied nodes
        insertCopyNodes(head);
        // Step 2: Assign random pointers
        connectRandomPointers(head);
        // Step 3: Assign next pointers & Separate original and copied lists
        return separateLists(head);
    }

    // --------------STEP 1 -------------
    // Original : 7 -> 13 -> 11 -> 10 -> 1
    // After this : 7 -> 7' -> 13 -> 13' -> 11 -> 11' -> 10 -> 10' -> 1 -> 1'
    private void insertCopyNodes(Node head) {

        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.val);

            copyNode.next = temp.next;
            temp.next = copyNode;

            temp = copyNode.next;
        }
    }

    // STEP 2 - Since copy of every node is immediately after it:
    
    // temp.random       -> original random node
    // temp.random.next  -> copied random node
    private void connectRandomPointers(Node head) {

        Node temp = head;
        while (temp != null) {
            Node copyNode = temp.next;

            if (temp.random != null) {
                copyNode.random = temp.random.next;
            }

            temp = copyNode.next;
        }
    }

    // STEP 3 - Separate:
    
    // Original: 7 -> 13 -> 11 -> 10 -> 1
    // Copy:     7' -> 13' -> 11' -> 10' -> 1'
    private Node separateLists(Node head) {

        Node temp = head;
        Node copyHead = head.next;

        while (temp != null) {
            Node copyNode = temp.next;
            // Restore original list
            temp.next = copyNode.next;
            // Connect copied list
            if (copyNode.next != null) {
                copyNode.next = copyNode.next.next;
            }

            temp = temp.next;
        }

        return copyHead;
    }
    
}