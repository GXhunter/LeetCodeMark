package 动态规划;

/**
 * <a href="https://leetcode.cn/problems/unique-paths/">...</a>
 */
public class 不同路径 {
    public int uniquePaths(int m, int n) {
//        走到 {m,n}点 有几种不同走法
        int[][] memo = new int[m][n];
        for (int i = 0; i < n; i++) {
            memo[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            memo[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j-1];
            }
        }
        return memo[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new 不同路径().uniquePaths(3, 2));
    }
}
