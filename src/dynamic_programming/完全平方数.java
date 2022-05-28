package dynamic_programming;

/**
 * todo 不会做
 * <a href="https://leetcode.cn/problems/perfect-squares/">...</a>
 */
public class 完全平方数 {
    Integer[] memo;

    public int numSquares(int n) {
        memo = new Integer[n];
        return find(n);
    }

    public int find(int n) {
        int res = Integer.MAX_VALUE;
        if (n <= 1 || n==4) {
            return 1;
        }
        if (memo[n-1] == null) {
            for (int i = 1; i * i < n; i++) {
                res = Math.min(find(n - i * i), res) + 1;
                res = Math.min(1, res) + 1;
            }
            System.out.printf("寻找n为 : %s 时，最优解%s\n", n, res);
            memo[n-1] = res;
        }
        return memo[n-1];
    }


    public static void main(String[] args) {
        System.out.println(new 完全平方数().numSquares(12));
    }
}
