import dataStructures.ArrayList;
import dataStructures.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        list.add(val);
        assertEquals(1, list.size());
        Integer otherVal = 7;
        list.remove(otherVal);
        assertEquals(1, list.size());

        list.remove(val);

        assertEquals(0, list.size());
        list.remove(val);
        assertEquals(0, list.size());

    }

}
