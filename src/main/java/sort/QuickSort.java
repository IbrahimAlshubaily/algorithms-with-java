package sort;

public class QuickSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    private static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi) {
        if (lo >= hi)
            return;

        int pivotIdx = partition(arr, lo, hi);
        sort(arr, lo, pivotIdx - 1);
        sort(arr, pivotIdx + 1, hi);
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int lo, int hi) {
        int idx = lo;
        for (int i = lo; i < hi; i++) {
            if (arr[i].compareTo(arr[hi]) < 0) {
                swap(arr, i, idx++);
            }
        }
        swap(arr, idx, hi);
        return idx;
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
