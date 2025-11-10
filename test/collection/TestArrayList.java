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
        assertFalse(arrayList.contains(null));
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
    public void testAddLast() {
        int size = arrayList.size();
        arrayList.addLast(null);
        assertEquals(size, arrayList.size());

        String v = "si";
        arrayList.addLast(v);
        assertEquals(size + 1, arrayList.size());
        assertEquals(v, arrayList.get(size));
    }

    @Test
    public void testCheckAndExtendSize() {

    }
}