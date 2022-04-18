package at.fhhgb.mtd.gop.veccy.data;

import at.fhhgb.mtd.gop.veccy.shapes.Shape;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DoubleLinkedList implements Iterable<Shape> {
    private Node head, tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    /** Prepend a new node to the beginning */
    public void prepend(Shape val) {
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
    public void append(Shape val) {
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
    public Shape get(int index) {
        Node node = this.head;
        int i = 0;

        while (node != null) {
            if (index == i) {
                return node.value;
            }
            i++;
            node = node.next;
        }
        return null;
    }

    /** Return the value and delete the first node */
    public Shape removeFirst() {
        Shape v = this.head.value;
        Node node = this.head.next;
        if (node != null) {
            this.head = node;
            node.prev = null;
            return v;
        }
        return null;
    }

    /** Return the value of the first node */
    public Shape peekFirst() {
        if (this.head != null) {
            return this.head.value;
        }

        return null;
    }
    /** Return the value and delete the last node */
    public Shape removeLast() {
        Shape v;
        Node node = this.tail.prev;
        if (node != null) {
            v = this.tail.value;
            this.tail = node;
            node.prev = null;
            return v;
        }
        return null;
    }

    /** Return the value of the last node */
    public Shape peekLast() {
        if (this.tail != null) {
            return this.tail.value;
        }
        return null;
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
        while (node != null) {
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

    /** Erstellt eine neue Instanz des DoubleLinkedListIterator, die verwendet
     * werden kann, um via for(Shape s : list) über die Liste zu iterieren. */
    @Override
    public Iterator<Shape> iterator() {
        return new DoubleLinkedListIterator(this.head);
    }

    @Override
    public void forEach(Consumer<? super Shape> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Shape> spliterator() {
        return Iterable.super.spliterator();
    }
}
