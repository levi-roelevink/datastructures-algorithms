package collection;

import collection.exceptions.EmptyCollectionException;
import collection.exceptions.ValueNotFoundException;

import java.util.Comparator;
import java.util.Iterator;

/**
 * A MyArrayList is a list, a linear data structure, which allows data to be
 * accessed at every position.
 *
 * @param <V> Type of objects to be contained.
 */
public class ArrayList<V> implements List<V>, Searchable<V>, Sortable<V> {

    private static final int MINIMUM_SIZE = 32;
    private static final int MAXIMUM_EXTENSION = 256;
    private Object[] elements;
    private int size;

    public ArrayList() {
        this(MINIMUM_SIZE);
    }

    public ArrayList(int capacity) {
        this.size = 0;
        elements = new Object[capacity];
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
        if (size == 0) return false;

        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                return true;
            }
        }

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
    @SuppressWarnings("unchecked")
    public V get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index);

        return (V) elements[index];
    }

    /**
     * Add the given value at the end of the list
     *
     * @param value the value to add
     */
    @Override
    public void addLast(V value) {
        checkAndExtendSize(size);
        elements[size] = value;
        size++;
    }

    /**
     * Check if the array of elements can hold another element and if not extend
     * the array. Make room on position index and adjust size. Time complexity:
     * O(n)
     *
     * @param index position where to make room for a new element, valid 0..size
     *              (size == add at end)
     * @throws IndexOutOfBoundsException index < 0 or index > size
     */
    private void checkAndExtendSize(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException(index);

        if (size == elements.length) {
            if (elements.length == MAXIMUM_EXTENSION) {
                throw new RuntimeException("Error extending ArrayList: maximum ArrayList size reached.");
            }

            Object[] copy = new Object[Math.max(elements.length * 2, MAXIMUM_EXTENSION)];
            System.arraycopy(elements, 0, copy, 0, elements.length);
            elements = copy;
        }
    }

    /**
     * Add the given value at the beginning of the list
     *
     * @param value the value to add
     */
    @Override
    public void addFirst(V value) {
        checkAndExtendSize(size);
        // Move all elements 1 position right so that value can be added at index 0
        System.arraycopy(elements, 0, elements, 1, size);
        elements[0] = value;
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
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index);

        checkAndExtendSize(size);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = value;
        size++;
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
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index);
        elements[index] = value;
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
        return removeAt(size - 1);
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
     * @throws EmptyCollectionException  empty list
     */
    @Override
    @SuppressWarnings("unchecked")
    public V removeAt(int index) throws EmptyCollectionException, IndexOutOfBoundsException {
        if (size == 0) throw new EmptyCollectionException();
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index);

        V v = (V) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return v;
    }

    /**
     * Removes the element on the "index"th position in the list. Throws an
     * ValueNotFoundException if the value is not in the list
     * If multiple elements in the list have the same value specified in the param then only the first one is removed.
     *
     * @param value value to remove
     * @throws ValueNotFoundException value not found
     */
    @Override
    public void remove(V value) throws ValueNotFoundException {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(value)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                size--;
                return;
            }
        }

        throw new ValueNotFoundException(value.toString());
    }

    /**
     * Checks if the list is empty. Time complexity: O(1)
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Determines the number of elements in this list by returning the value of
     * a variable. Time complexity: O(1)
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
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
     * @param begin      start of range
     * @param end        end of range
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
     * @param element    the element to search for
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
