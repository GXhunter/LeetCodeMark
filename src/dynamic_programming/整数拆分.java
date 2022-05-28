package dynamic_programming;

public class 整数拆分 {
    Integer[] memo;

    public int integerBreak(int n) {
        memo = new Integer[n];
        int res = 0;
        //        拆分成 i 和 f(n-i) 乘积
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, i * find(n - i));
        }
        return res;
    }

    public int find(int n) {
        if (n < 2) {
            return n;
        }
        if (memo[n - 1] == null) {

            int res = 0;

//        拆分成 i 和 f(n-i) 乘积
            for (int i = 1; i <= n; i++) {
                res = Math.max(res, i * find(n - i));
                res = Math.max(res, n);
            }
            memo[n - 1] = res;
        }
        return memo[n - 1];
    }


    public static void main(String[] args) {
        System.out.println(new 整数拆分().integerBreak(10));
    }
}
