package 剑指offer;

public class 剪绳子 {
    Integer[] cache;

    public int cuttingRope(int n) {
        cache = new Integer[n + 1];
        return cuttingRope2(n, 0);
    }

    public int cuttingRope2(int n, int index) {
        if (cache[n] != null) {
            return cache[n];
        }
        int max = index == 0 ? 0 : n;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, cuttingRope2(n - i, index + 1) * i);
        }
        cache[n] = max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 剪绳子().cuttingRope(30));
    }
}
