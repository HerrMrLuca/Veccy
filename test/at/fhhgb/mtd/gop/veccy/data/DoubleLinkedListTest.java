package at.fhhgb.mtd.gop.veccy.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    @Test
    void prepend() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(4);
        list.append(5);
        list.prepend(3);
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);

        assertEquals(1, list.get(0));
    }

    @Test
    void append() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(4);
        list.append(5);
        list.prepend(3);
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);

        assertEquals(5, list.get(5));
    }

    @Test
    void get() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(4);
        list.append(5);
        list.prepend(3);
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);

        assertEquals(5, list.get(5));
    }

    @Test
    void removeFirst() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(4);
        list.append(5);
        list.prepend(3);
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);

        assertEquals(1, list.removeFirst());
    }

    @Test
    void peekFirst() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(4);
        list.append(5);
        list.prepend(3);
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);

        assertEquals(1, list.peekFirst());
    }

    @Test
    void removeLast() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(4);
        list.append(5);
        list.prepend(3);
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);

        assertEquals(5, list.removeLast());
    }

    @Test
    void peekLast() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(4);
        list.append(5);
        list.prepend(3);
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);

        assertEquals(5, list.peekLast());
    }

    @Test
    void reverse() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(4);
        list.append(5);
        list.prepend(3);
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);
        list.reverse();

        assertEquals(1, list.peekLast());

    }

    @Test
    void size() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(4);
        list.append(5);
        list.prepend(3);
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);

        assertEquals(6, list.size());
    }

    @Test
    void clear() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(4);
        list.append(5);
        list.prepend(3);
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);
        list.clear();

        assertEquals(0, list.size());
    }
}