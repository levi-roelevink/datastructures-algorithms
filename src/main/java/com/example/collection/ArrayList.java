package com.example.collection;

import java.util.Comparator;
import java.util.Iterator;

import com.example.collection.exceptions.EmptyCollectionException;
import com.example.collection.exceptions.ValueNotFoundException;

/**
 * A MyArrayList is a list, a linear data structure, which allows data to be
 * accessed at every position.
 *
 * @param <V> Type of objects to be contained.
 */
public class ArrayList<V> implements List<V>, Searchable<V>, Sortable<V> {

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
        return (V) null;
    }

    /**
     * Add the given value at the end of the list
     *
     * @param value the value to add
     */
    @Override
    public void addLast(V value) {
    }

    /**
     * Add the given value at the beginning of the list
     *
     * @param value the value to add
     */
    @Override
    public void addFirst(V value) {

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
        return (V) null;
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
        return (V) null;
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
        return (V) null;
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
     * Checks if the list is empty. Time complexity: O(1)
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Determines the number of elements in this list by returning the value of
     * a variable. Time complexity: O(1)
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Check if the list is sorted according to the given comparator. Time
     * complexity O(n)
     *
     * @param comparator the comparator to determine the order of the list
     * @return true if the list is sorted, false otherwise
     */
    @Override
    public boolean isSorted(Comparator<V> comparator) {
        return false;
    }

    /**
     * Do a selection sort (in place) on the elements in ascending order. Time
     * complexity: O(n^2)
     *
     * @param comparator the comparator to determine the order of the list
     */
    @Override
    public void simpleSort(Comparator<V> comparator) {
    }

    /**
     * Recursively do a quick sort (in place) on the elements in ascending
     * order.
     *
     * @param comparator method to compare two V objects
     */
    @Override
    public void quickSort(Comparator<V> comparator) {
    }

    /**
     * Recursively do a quick sort (in place) on the elements from begin until
     * (including) end in ascending order.
     *
     * @param comparator method to compare two V objects
     * @param begin start of range
     * @param end end of range
     */
    private void quickSort(Comparator<V> comparator, int begin, int end) {
    }

    /**
     * Perform a linear search for the specified element. Time complexity: O(n)
     *
     * @param element the element to search for
     * @return the index of the element if found, otherwise
     * SaxSearchable.NOT_FOUND
     */
    @Override
    public int linearSearch(Object element) {
        return 0;
    }

    /**
     * Perform a binary search for the specified element. Time complexity:
     * O(log(n))
     *
     * @param comparator the comparator to determine the order of the list
     * @param element the element to search for
     * @return the index of the element if found, otherwise
     * SaxSearchable.NOT_FOUND
     */
    @Override
    public int binarySearch(Comparator<V> comparator, V element) {
        return 0;
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
    // Do no perform type checking; a Java hack, because we store objects of a generic type V in an Object array
    @Override
    public String graphViz(String name) {
        return "";
    }

    /**
     * Returns an iterator over elements of type V. The iterator traverses the
     * list from the head to the tail.
     *
     * @return an Iterator over elements of type V
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            // TODO: theres more methods in the iterator returned
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public V next() {
                return (V) null;
            }
        };
    }
}
