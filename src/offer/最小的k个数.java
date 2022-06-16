package offer;

import java.util.Arrays;

public class 最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
}
