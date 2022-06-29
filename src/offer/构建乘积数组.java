package offer;

/**
 * 双前缀技巧
 */
public class 构建乘积数组 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        if (n == 0) {
            return a;
        }
        int[] res1 = new int[n];
        res1[0] = 1;
        for (int i = 1; i < n; i++) {
            res1[i] = res1[i - 1] * a[i - 1];
        }

        int[] res2 = new int[n];
        res2[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            res2[i] = res2[i + 1] * a[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res1[i] = res1[i] * res2[i];
        }
        return res1;
    }

    public static void main(String[] args) {
        new 构建乘积数组().constructArr(new int[]{1, 2, 3, 4, 5});
    }
}
