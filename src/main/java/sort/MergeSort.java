package sort;

public class MergeSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1); // inplace N2 * logN
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi) {
        if (hi <= lo)
            return;

        int mid = lo + (hi - lo) / 2;
        if (arr[mid].compareTo(arr[mid + 1]) < 1)
            return;

        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, hi);
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int lo, int hi) {
        int left = lo;
        int mid = lo + ((hi - lo) / 2);
        int right = mid + 1;
        while (left <= mid) {
            if (arr[left].compareTo(arr[right]) <  1) {
                left++;
                continue;
            }

            swap(arr, right, left);
            bubble(arr, right, hi);
            left++;
        }
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static <T extends Comparable<T>> void bubble(T[] arr, int lo, int hi) {
        while (lo < hi && arr[lo].compareTo(arr[lo + 1]) >  0) {
            swap(arr, lo, lo + 1);
            lo++;
        }
    }
}
