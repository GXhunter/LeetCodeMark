package dynamic_programming;

public class 爬楼梯2 {
    public int climbStairs(int n) {
        if (n == 1 || n==0) {
            return 1;
        }
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new 爬楼梯2().climbStairs(1));
    }
}
