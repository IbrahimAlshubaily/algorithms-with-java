package search;

public class BinarySearch {

    public static <T extends Comparable<T>> int find(T[] hayStack, T needle) {

        int lo = 0;
        int hi = hayStack.length - 1;
        int mid;
        int needleIdx = -1;
        while(lo <= hi){
            mid = lo +  (hi-lo) / 2;
            if (hayStack[mid].compareTo(needle) == 0) {
                needleIdx = mid;
                break;
            } else if (hayStack[mid].compareTo(needle) < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return needleIdx;
    }

}
