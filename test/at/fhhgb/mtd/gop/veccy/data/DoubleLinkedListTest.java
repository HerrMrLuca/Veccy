package at.fhhgb.mtd.gop.veccy.data;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {
    Rectangle rec = new Rectangle();
    Rectangle rec2 = new Rectangle(100, 100, 100, 100);
    Rectangle rec3 = new Rectangle(200, 200, 100, 100);
    Rectangle rec4 = new Rectangle(300, 300, 100, 100);
    Rectangle rec5 = new Rectangle(400, 400, 100, 100);

    @Test
    void prepend() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(rec);
        list.append(rec2);
        list.prepend(rec3);
        list.prepend(rec4);
        list.prepend(rec5);

        assertEquals(new Rectangle(400, 400, 100, 100), list.get(0));
    }

    @Test
    void append() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(rec);
        list.append(rec2);
        list.prepend(rec3);
        list.prepend(rec4);
        list.prepend(rec5);

        assertEquals(new Rectangle(100, 100, 100, 100), list.get(4));
    }

    @Test
    void get() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(rec);
        list.append(rec2);
        list.prepend(rec3);
        list.prepend(rec4);
        list.prepend(rec5);

        assertEquals(rec2, list.get(4));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(10);
        });
    }

    @Test
    void removeFirst() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(rec);
        list.append(rec2);
        list.prepend(rec3);
        list.prepend(rec4);
        list.prepend(rec5);

        assertEquals(rec5, list.removeFirst());
        assertEquals(rec4, list.removeFirst());
        list.removeFirst();
        assertEquals(rec, list.removeFirst());
        assertNull(list.removeFirst());
        list.removeFirst();
        assertNull(list.removeFirst());
    }

    @Test
    void peekFirst() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(rec);
        list.append(rec2);
        list.prepend(rec3);

        list.prepend(rec4);
        assertEquals(rec4, list.peekFirst());

        list.prepend(rec5);
        assertEquals(rec5, list.peekFirst());
    }

    @Test
    void removeLast() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(rec);
        list.append(rec2);
        list.prepend(rec3);
        list.prepend(rec4);
        list.prepend(rec5);

        assertEquals(rec2, list.removeLast());
    }

    @Test
    void peekLast() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(rec);
        list.append(rec2);
        list.prepend(rec3);
        list.prepend(rec4);
        list.prepend(rec5);

        assertEquals(rec2, list.peekLast());
    }

    @Test
    void reverse() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(rec);
        list.append(rec2);
        list.prepend(rec3);
        list.prepend(rec4);
        list.prepend(rec5);
        list.reverse();

        assertEquals(rec5, list.peekLast());
        assertEquals(rec2, list.peekFirst());

    }

    @Test
    void size() {
        DoubleLinkedList list = new DoubleLinkedList();
        assertEquals(0, list.size());
        list.append(rec);
        list.append(rec2);
        list.prepend(rec3);
        list.prepend(rec4);
        list.prepend(rec5);

        assertEquals(5, list.size());
    }

    @Test
    void clear() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(rec);
        list.append(rec2);
        list.prepend(rec3);
        list.prepend(rec4);
        list.prepend(rec5);
        list.clear();

        assertEquals(0, list.size());
        assertNull(list.peekFirst());
    }
}