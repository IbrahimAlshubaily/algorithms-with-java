import dataStructures.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapTest {

    private HashMap<String, Integer> map;
    @BeforeEach
    void setUp() {
        map = new HashMap<>();
    }

    @Test
    void generalTest() {

        assertTrue(map.isEmpty());
        assertEquals(0, map.size());

        assertFalse(map.containsKey("A"));
        assertFalse(map.containsValue(0));
        assertNull(map.put("A", 0));
        assertEquals(0, map.get("A"));
        assertTrue(map.containsKey("A"));
        assertTrue(map.containsValue(0));

        assertEquals(1, map.size());
        assertFalse(map.isEmpty());

        assertEquals(0,map.put("A", 1));
        assertTrue(map.containsValue(1));
        assertFalse(map.containsValue(0));
        assertEquals(1,map.get("A"));
        assertTrue(map.containsKey("A"));

        assertEquals(1, map.size());


        assertFalse(map.containsKey("B"));
        assertNull(map.put("B", 0));
        assertTrue(map.containsKey("B"));
        assertTrue(map.containsValue(0));

        assertEquals(2, map.size());

        assertEquals(1, map.remove("A"));
        assertFalse(map.containsKey("A"));
        assertFalse(map.containsValue(1));
        assertEquals(1, map.size());

        assertTrue(map.containsKey("B"));
        assertTrue(map.containsValue(0));
        assertEquals(0, map.get("B"));
        assertEquals(0, map.remove("B"));
        assertFalse(map.containsKey("B"));
        assertFalse(map.containsValue(1));
        assertEquals(0, map.size());

        assertTrue(map.isEmpty());

    }

}
