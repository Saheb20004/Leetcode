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


// First pass → create a copy of every node and store:
// original node -> copied node
// Second pass → connect next and random using the map.

class Solution {
    public Node copyRandomList(Node head) {
        // Edge Case
        if (head == null) {
            return null;
        }

        // original node -> copied node
        HashMap<Node, Node> map = new HashMap<>();

        // First pass: create all copied nodes
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);

            temp = temp.next;
        }

        // Second pass: connect next and random
        temp = head;
        while (temp != null) {
            Node copyNode = map.get(temp);

            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);

            temp = temp.next;
        }

        return map.get(head);
    }
}