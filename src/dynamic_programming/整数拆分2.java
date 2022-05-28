package dynamic_programming;

public class 整数拆分2 {
    Integer[] memo;

    public int integerBreak(int n) {
        memo = new Integer[n+1];
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3; i <= n; i++) {
            int res = 0;
//            拆分成 j * memo[i-j]
            for (int j = 1; j < i; j++) {
                res = Math.max(res, j * memo[i - j]);
//                这一步很关键，可以不继续往下拆
                res = Math.max(res, j * (i - j));
            }
            memo[i] = res;
        }
        return memo[n];
    }



    public static void main(String[] args) {
        System.out.println(new 整数拆分2().integerBreak(10));
    }
}
