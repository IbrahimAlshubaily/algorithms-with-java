import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.BubbleSort;
import sort.MergeSort;
import sort.QuickSort;
import sort.SelectionSort;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortTest {
    Integer[] nums;
    @BeforeEach
    void setUp() {
        nums = new Integer[] {9, 1, 8, 7, 2, 5, -2, 5, -99, 0, 12, 55, 7, 77, 8};
    }

    @Test
    void testMergeSort() {
        MergeSort.sort(nums);
        assertTrue(isSorted(nums));
    }

    @Test
    void testQuickSort() {
        QuickSort.sort(nums);
        assertTrue(isSorted(nums));
    }

    @Test
    void testBubbleSort() {
        BubbleSort.sort(nums);
        assertTrue(isSorted(nums));
    }

    @Test
    void testSelectionSort() {
        SelectionSort.sort(nums);
        assertTrue(isSorted(nums));
    }

    public static boolean isSorted(Integer[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                return false;
            }
        }
        return true;
    }


}
