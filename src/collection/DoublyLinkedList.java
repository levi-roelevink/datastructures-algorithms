package collection;

import collection.exceptions.EmptyCollectionException;
import collection.exceptions.ValueNotFoundException;
import collection.nodes.Node;

import java.util.Iterator;

public class DoublyLinkedList<V> implements List<V> {
    private Node<V> head;
    private Node<V> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Check if a given value is in the collection Uses V.equals() to check for
     * equality.
     *
     * @param value the value to search for
     * @return if the value is in the collection
     */
    @Override
    public boolean contains(V value) {
        return false;
    }

    /**
     * Get the value in the list at the specific index.
     *
     * @param index the index of the element to retrieve
     * @return value at the given index
     * @throws IndexOutOfBoundsException invalid index
     */
    @Override
    public V get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    /**
     * Add the given value at the end of the list
     *
     * @param value the value to add
     */
    @Override
    public void addLast(V value) {
        Node<V> node;

        if (size == 0) {
            node = new Node<V>(value);
            head = node;
        } else {
            node = new Node<V>(value, tail, null);
            tail.setNext(node);
        }

        tail = node;
        size++;
    }

    /**
     * Add the given value at the beginning of the list
     *
     * @param value the value to add
     */
    @Override
    public void addFirst(V value) {
        Node<V> node;

        if (size == 0) {
            node = new Node<V>(value);
            tail = node;
        } else {
            node = new Node<V>(value, null, head);
            head.setPrev(node);
        }

        head = node;
        size++;
    }

    /**
     * Add (insert) the given value at the "index"th position in the list Throws
     * an IndexOutOfBoundsException if the index < 0 or >= size
     *
     * @param index index where the value is to be added
     * @param value the value to add
     * @throws IndexOutOfBoundsException invalid index
     */
    @Override
    public void addAt(int index, V value) throws IndexOutOfBoundsException {
        // TODO: Why does the documentation say to throw an exception if index == size?
        if (index < 0 || index > size) throw new IndexOutOfBoundsException(index);
        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node<V> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }

            System.out.println(current.getVal());
            Node<V> prev = current.getPrev();
            Node<V> node = new Node<V>(value, prev, current);
            prev.setNext(node);
            current.setPrev(node);
        }
    }

    /**
     * Sets the given value at the "index"th position in the list Throws an
     * IndexOutOfBoundsException if the index < 0 or >= size
     *
     * @param index index where the value is to be set
     * @param value the value to set
     * @throws IndexOutOfBoundsException invalid index
     */
    @Override
    public void set(int index, V value) throws IndexOutOfBoundsException {

    }

    /**
     * Removes the last element of the list. Throws an EmptyCollectionException
     * if the list is empty
     *
     * @return the removed value
     * @throws EmptyCollectionException nothing to remove
     */
    @Override
    public V removeLast() throws EmptyCollectionException {
        return null;
    }

    /**
     * Removes the first element of the list. Throws an EmptyCollectionException
     * if the list is empty
     *
     * @return the removed value
     * @throws EmptyCollectionException nothing to remove
     */
    @Override
    public V removeFirst() throws EmptyCollectionException {
        return null;
    }

    /**
     * Removes the element at position index of the list. Throws an
     * EmptyCollectionException if the list is empty
     *
     * @param index index where the value is to be removed
     * @return the removed value
     * @throws IndexOutOfBoundsException invalid index
     */
    @Override
    public V removeAt(int index) throws IndexOutOfBoundsException {
        return null;
    }

    /**
     * Removes the element on the "index"th position in the list. Throws an
     * ValueNotFoundException if the value is not in the list
     *
     * @param value value to remove
     * @throws ValueNotFoundException value not found
     */
    @Override
    public void remove(V value) throws ValueNotFoundException {

    }

    /**
     * Determines if the collection has no elements
     *
     * @return if the collection has no elements
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Determines the number of elements in this collection
     *
     * @return size of this collection
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        Node<V> next = head;
        while (next != null) {
            sb.append(next.getVal());
            next = next.getNext();
            if (next != null) {
                sb.append(", ");
            }
        }

        sb.append(']');
        return sb.toString();
    }

    /**
     * Create a String representation of the data in GraphViz (see
     * <a href="https://graphviz.org">GraphViz</a>) format, which you can
     * print-copy-paste on the site see
     * <a href="https://dreampuf.github.io/GraphvizOnline">GraphViz online</a>.
     *
     * @param name name of the produced graph
     * @return a GraphViz string representation of this collection
     */
    @Override
    public String graphViz(String name) {
        return "";
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<V> iterator() {
        return null;
    }
}
