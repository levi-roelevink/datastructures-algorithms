package collection;

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

        arrayList.set(5, v);
        assertEquals(v, arrayList.get(5));
        assertEquals(size, arrayList.size());
    }
}