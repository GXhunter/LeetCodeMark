package dynamic_programming;

public class 不同路径2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        memo[0][0] = obstacleGrid[0][0]==1?-1:1;
        for (int i = 1; i < n; i++) {
            memo[0][i] = obstacleGrid[0][i] == 1 || memo[0][i - 1] == -1 ? -1 : memo[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            memo[i][0] = obstacleGrid[i][0] == 1 || memo[i - 1][0] == -1 ? -1 : memo[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = 0;
                if (obstacleGrid[i][j] == 1) {
                    memo[i][j] = -1;
                    continue;
                }
                if (memo[i - 1][j] != -1) {
                    memo[i][j] += memo[i - 1][j];
                }
                if (memo[i][j - 1] != -1) {
                    memo[i][j] += memo[i][j - 1];
                }
            }
        }
        return memo[m - 1][n - 1]==-1?0:memo[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new 不同路径2().uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        }));
    }
}
