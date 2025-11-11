package collection;

import collection.exceptions.EmptyCollectionException;
import collection.exceptions.ValueNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayList {
    // TODO: Make sure a lot of resizing has to be done
    private ArrayList<String> arrayList;

    @BeforeEach
    void createExampleList() {
        arrayList = new ArrayList<>();
        arrayList.addLast("do");
        arrayList.addLast("re");
        arrayList.addLast("mi");
        arrayList.addLast("fa");
        arrayList.addLast("sol");
        arrayList.addLast("la");
        arrayList.addLast("ti");
    }

    @Test
    public void GivenExampleList_WhenNoChanges_ConfirmInitialContent() {
        assertEquals(7, arrayList.size());
        assertEquals("do", arrayList.get(0));
        assertEquals("ti", arrayList.get(6));
        assertTrue(arrayList.contains("re"));
        assertFalse(arrayList.contains("et"));
    }

    @Test
    public void GivenNewList_WhenNoChanges_ConfirmInitialContent() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        assertTrue(integerArrayList.isEmpty());
        assertEquals(0, integerArrayList.size());
        assertFalse(integerArrayList.contains(0));
    }

    @Test
    public void GivenExampleList_WhenGetIndexOutOfBounds_ExpectException() {
        assertFalse(arrayList.isEmpty());
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(arrayList.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(arrayList.size() + 1));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(arrayList.size() * 999));
    }

    // TODO: test checkAndExtendSize method

    @Test
    public void testAddLastAndFirst() {
        int size = arrayList.size();

        String v = "si";
        arrayList.addLast(v);
        assertEquals(size + 1, arrayList.size());
        assertEquals(v, arrayList.get(size));

        arrayList.addFirst(v);
        assertEquals(v, arrayList.get(0));
        assertEquals(size + 2, arrayList.size());
        assertEquals(v, arrayList.get((size + 1)));
    }

    @Test
    public void addAtTest() {
        int size = arrayList.size();
        String v = "boo";
        arrayList.addAt(2, v);
        assertEquals("re", arrayList.get(1));
        assertEquals(v, arrayList.get(2));
        assertEquals("mi", arrayList.get(3));
        assertEquals(size + 1, arrayList.size());

        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.addAt(-1, v));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.addAt(size + 1, v));
    }

    @Test
    public void setTest() {
        String v = "Volvo";
        int size = arrayList.size();
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(-1, v));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(size, v));
        assertFalse(arrayList.contains(v));

        arrayList.set(5, v);
        assertEquals(v, arrayList.get(5));
        assertEquals(size, arrayList.size());
    }

    @Test
    public void removeTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        int size = list.size();

        list.remove(3);
        assertFalse(list.contains(3));
        assertEquals(size - 1, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(4, list.get(2));
        assertEquals(5, list.get(3));

        list.remove(1);
        list.remove(2);
        list.remove(4);
        list.remove(5);
        assertEquals(0, list.size());
    }

    @Test
    public void GivenExampleList_WhenRemovingValueNotInList_ExpectException() {
        String v = "Volvo";
        assertFalse(arrayList.contains(v));
        String expectedException = String.format("Value for \"%s\" not found.", v);
        ValueNotFoundException exception = assertThrows(ValueNotFoundException.class, () -> arrayList.remove(v));
        assertEquals(expectedException, exception.getMessage());
    }

    @Test
    public void GivenEmptyList_WhenRemovingElement_ExpectException() {
        ArrayList<Integer> list = new ArrayList<>();
        assertThrows(EmptyCollectionException.class, () -> list.removeAt(0));
        assertThrows(EmptyCollectionException.class, list::removeLast);
    }

    @Test
    public void GivenExampleList_WhenRemovingAtInvalidIndex_ExpectException() {
        int size = arrayList.size();
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.removeAt(size));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.removeAt(-1));
        assertEquals(size, arrayList.size());
    }

    @Test
    public void GivenExampleList_WhenRemovingAtIndex_ExpectElementToBeRemoved() {
        String removed = arrayList.get(4);
        int size = arrayList.size();
        assertEquals(removed, arrayList.removeAt(4));
        assertFalse(arrayList.contains(removed));
        assertEquals(size - 1, arrayList.size());
        assertEquals("fa", arrayList.get(3));
        assertEquals("la", arrayList.get(4));
        assertEquals("ti", arrayList.get(5));
    }

    @Test
    public void GivenExampleList_WhenRemovingLastSizeTimes_ExpectEmptyList() {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.removeLast();
        }

        assertEquals(0, arrayList.size());
    }

    @Test
    public void GivenExampleList_WhenRemovingFirstSizeTimes_ExpectEmptyList() {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.removeFirst();
        }

        assertEquals(0, arrayList.size());
    }

    @Test
    public void GivenExampleList_WhenToString_ExpectStringRepresentation() {
        String expected = "[do, re, mi, fa, sol, la, ti]";
        assertEquals(expected, arrayList.toString());
    }

    @Test
    public void GivenExampleList_WhenLinearlySearching_ExpectIndexReturned() {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String val = arrayList.get(i);
            int index = arrayList.linearSearch(val);
            assertEquals(i, index);
        }
    }

    @Test
    public void GivenExampleList_WhenSearchingForNonExistingElement_ExpectNotFound() {
        assertEquals(Searchable.NOT_FOUND, arrayList.linearSearch("Volvo"));
        // TODO: add other search algorithms
    }
}