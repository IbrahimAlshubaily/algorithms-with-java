import dataStructures.ArrayList;
import dataStructures.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

    @Test
    void testArrayList() {
        ArrayList<Integer> list = new ArrayList();
        testList(list);
    }

    @Test
    void testLinkedList() {
        LinkedList<Integer> list = new LinkedList();
        testList(list);
    }

    <T> void testList(List<Integer> list) {

        assertEquals(0, list.size());

        list.remove(0);
        assertEquals(0, list.size());

        Integer val = 1;
        assertFalse(list.contains(val));

        list.add(val);
        assertTrue(list.contains(val));
        assertEquals(1, list.size());

        Integer otherVal = 7;
        assertFalse(list.contains(otherVal));
        list.remove(otherVal);
        assertEquals(1, list.size());

        assertTrue(list.contains(val));
        list.remove(val);
        assertFalse(list.contains(val));

        assertEquals(0, list.size());
        list.remove(val);
        assertEquals(0, list.size());

        
    }

}
