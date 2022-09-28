package sort;

public class SelectionSort {

    public static void sort(Integer[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIdx = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = tmp;
        }
    }
}
