package dynamic_programming;

/**
 * 动态规划解法
 */
public class 最小路径和2 {
    /**
     * 走到坐标{i,j} 的最短路径
     */
    Integer[][] memo;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[grid.length - 1].length;
        memo = new Integer[m][n];
        memo[0][0] = grid[0][0];
//        第一行填充
        for (int i = 1; i < n; i++) {
            memo[0][i] = memo[0][i - 1] + grid[0][i];
        }
//        第一列填充
        for (int i = 1; i < m; i++) {
            memo[i][0] = memo[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = grid[i][j]
                        + Math.min(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        return memo[m-1][n-1];
    }


    public static void main(String[] args) {
        System.out.println(new 最小路径和2().minPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        }));
    }
}
