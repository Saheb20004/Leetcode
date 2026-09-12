class MyLinkedList {

    int data;
    MyLinkedList next;

    MyLinkedList head;
    MyLinkedList tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public MyLinkedList(int data) {
        this.data = data;
        this.next = null;
    }

    public int get(int index) {
        // Invalid index
        if (index < 0 || head == null) {
            return -1;
        }

        MyLinkedList curr = head;

        // Move to the required index
        for (int i = 0; i < index; i++) {

            if (curr == null) {
                return -1;
            }

            curr = curr.next;
        }

        // Index was greater than length
        if (curr == null) {
            return -1;
        }

        return curr.data;
    }

    public void addAtHead(int val) {

        MyLinkedList newNode = new MyLinkedList(val);

        // Empty list
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addAtTail(int val) {
        MyLinkedList newNode = new MyLinkedList(val);

        // Empty list
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void addAtIndex(int index, int val) {
        // Invalid index
        if (index < 0) {
            return;
        }

        // Insert at beginning
        if (index == 0) {
            addAtHead(val);
            return;
        }

        MyLinkedList curr = head;

        // Find node just before index
        for (int i = 0; i < index - 1; i++) {

            if (curr == null) {
                return;
            }

            curr = curr.next;
        }

        // Index is greater than list length
        if (curr == null) {
            return;
        }

        // Insert at tail
        if (curr.next == null) {
            addAtTail(val);
            return;
        }

        MyLinkedList newNode = new MyLinkedList(val);

        newNode.next = curr.next;
        curr.next = newNode;
    }

    public void deleteAtIndex(int index) {

        // Invalid index or empty list
        if (index < 0 || head == null) {
            return;
        }

        // Delete head
        if (index == 0) {
            head = head.next;
            // List became empty
            if (head == null) {
                tail = null;
            }
            return;
        }

        MyLinkedList curr = head;

        // Find node before the node to delete
        for (int i = 0; i < index - 1; i++) {
            if (curr == null) {
                return;
            }

            curr = curr.next;
        }

        // Index doesn't exist
        if (curr == null || curr.next == null) {
            return;
        }

        // If deleting tail
        if (curr.next == tail) {
            tail = curr;
        }

        // Remove node
        curr.next = curr.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */