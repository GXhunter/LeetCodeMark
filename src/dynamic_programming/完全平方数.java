package dynamic_programming;

/**
 * todo 不会做
 * <a href="https://leetcode.cn/problems/perfect-squares/">...</a>
 */
public class 完全平方数 {

    /**
     * 转移方程: F(n) = min(F(n),F(n-i*i)+1)
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int [] memo = new int[n+1];
        for (int i = 1; i <= n; i++) {
            memo[i] = i;
            for (int j = 1; j*j <= i; j++) {
                memo[i] = Math.min(memo[i], memo[i - j * j] + 1);
            }
        }
        return memo[n];
    }



    public static void main(String[] args) {
        System.out.println(new 完全平方数().numSquares(12));
    }
}
