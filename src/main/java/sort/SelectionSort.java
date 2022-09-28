package sort;

public class SelectionSort {

    public static <T extends Comparable<T>> void sort(T[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIdx = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j].compareTo(nums[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            T tmp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = tmp;
        }
    }
}
