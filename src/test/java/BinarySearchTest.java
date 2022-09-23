
import org.junit.jupiter.api.Test;
import search.BinarySearch;


import static org.junit.jupiter.api.Assertions.*;


class BinarySearchTest {

    @Test
    void testBinarySearch(){
        Integer[] nums = new Integer[] {0, 2, 4, 6};

        assertEquals(-1, BinarySearch.find(nums, -1));

        assertEquals(0, BinarySearch.find(nums, 0));
        assertEquals(-1, BinarySearch.find(nums, 1));

        assertEquals(1, BinarySearch.find(nums, 2));
        assertEquals(-1, BinarySearch.find(nums, 3));

        assertEquals(2, BinarySearch.find(nums, 4));
        assertEquals(-1, BinarySearch.find(nums, 5));

        assertEquals(3, BinarySearch.find(nums, 6));
        assertEquals(-1, BinarySearch.find(nums, 7));

    }
}
