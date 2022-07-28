package 动态规划;

public class 最小路径之和 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
//        运动到{m,n} 点时，路径最小值
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                }else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new 最小路径之和().minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1},
        }));
    }
}
