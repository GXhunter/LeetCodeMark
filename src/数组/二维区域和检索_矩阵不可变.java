package 数组;

public class 二维区域和检索_矩阵不可变 {
    int memo[][];

    public 二维区域和检索_矩阵不可变(int[][] matrix) {
        int m = matrix.length,n=matrix[0].length;
        memo = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                memo[i][j] = memo[i - 1][j] + matrix[i - 1][j - 1] + memo[i][j - 1] - memo[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return memo[row2 + 1][col2 + 1]
                - memo[row2 + 1][col1]
                - memo[row1][col2 + 1]
                + memo[row1][col1];
    }
}
