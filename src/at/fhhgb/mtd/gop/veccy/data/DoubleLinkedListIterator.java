package at.fhhgb.mtd.gop.veccy.data;

import at.fhhgb.mtd.gop.veccy.shapes.Shape;

import java.util.Iterator;

public class DoubleLinkedListIterator implements Iterator<Shape> {
    private Node head;
    private Node currentNode;

    public DoubleLinkedListIterator(Node head) {
        this.head = head;
        this.currentNode = head;
    }
    /** Returniert true, wenn weitere Elemente verfügbar sind und via next()
     * zurückgegeben werden können. Returniert false, wenn das Ende der Liste
     * erreicht wurde und keine Elemente mehr vorhanden sind. */
    @Override
    public boolean hasNext() {
        return this.head.next != null;
    }
    /** Returniert das Shape der aktuellen Listenposition von currentNode.
     * Setzt weiters currentNode auf den nächsten Knoten, damit ein erneuter
     * Aufruf von next() das nächste Shape der Liste liefert. */
    @Override
    public Shape next() {
        currentNode = currentNode.next;
        return this.currentNode.prev.value;
    }
}
