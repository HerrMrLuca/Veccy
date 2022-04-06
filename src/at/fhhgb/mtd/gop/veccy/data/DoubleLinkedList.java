package at.fhhgb.mtd.gop.veccy.data;

public class DoubleLinkedList {
    private Node head, tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    /** Prepend a new node to the beginning */
    public void prepend(int val) {
        Node newNode = new Node();
        newNode.value = val;

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        this.head.prev = newNode;
        newNode.next = this.head;
        this.head = newNode;
    }

    /** Append a new node at the end */
    public void append(int val) {
        Node newNode = new Node();
        newNode.value = val;

        if (this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        this.tail.next = newNode;
        newNode.prev = this.head;
        this.tail = newNode;
    }

    /** Return the value of the node with the index */
    public int get(int index) {
        Node node = this.head;
        int i = 0;

        while (node != null) {
            if (index == i) {
                return node.value;
            }
            i++;
            node = node.next;
        }
        return Integer.MIN_VALUE;
    }

    /** Return the value and delete the first node */
    public int removeFirst() {
        int v = this.head.value;
        Node node = this.head.next;
        if (node != null) {
            this.head = node;
            node.prev = null;
            return v;
        }
        return Integer.MIN_VALUE;
    }

    /** Return the value of the first node */
    public int peekFirst() {
        if (this.head != null) {
            return this.head.value;
        }

        return Integer.MIN_VALUE;
    }
    /** Return the value and delete the last node */
    public int removeLast() {
        int v;
        Node node = this.tail.prev;
        if (node != null) {
            v = this.tail.value;
            this.tail = node;
            node.prev = null;
            return v;
        }
        return Integer.MIN_VALUE;
    }

    /** Return the value of the last node */
    public int peekLast() {
        if (this.tail != null) {
            return this.tail.value;
        }
        return Integer.MIN_VALUE;
    }


    /** Reverse the list in order */
    public void reverse() {
        DoubleLinkedList newList = new DoubleLinkedList();
        Node node = this.head;
        while (node != null) {
            for (int i = 0; i < size(); i++) {
                newList.prepend(this.get(i));
                node = node.next;
            }
        }

        this.head = newList.head;
        this.tail = newList.tail;
    }

    /** Returns the length of the list */
    public int size() {
        Node node = this.head;
        int x = 0;
        while (node != null) {
            x++;
            node = node.next;
        }
        return x;
    }

    /** Deletes all elements */
    public void clear() {
        Node node = this.head;
        while (node != null) {;
            node.prev = null;
            node = node.next;
        }
        head = null;
        tail = null;
    }

    public void replaceNode(DoubleLinkedList node) {
        this.head = node.head;
        this.tail = node.tail;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        if (this.head != null) {
            for (int i = 0; i < this.size(); i++) {
                str.append(this.get(i)).append(", ");
            }
            str.deleteCharAt(str.length() - 2);
        }
        return str.toString();
    }
}
