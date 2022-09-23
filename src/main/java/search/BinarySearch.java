package search;

public class BinarySearch {

    public static int find(Integer[] hayStack, int needle) {

        int lo = 0;
        int hi = hayStack.length - 1;
        int mid;
        int needleIdx = -1;
        while(lo <= hi){
            mid = lo +  (hi-lo) / 2;
            if (hayStack[mid] == needle) {
                needleIdx = mid;
                break;
            } else if (hayStack[mid] < needle) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return needleIdx;
    }

}
