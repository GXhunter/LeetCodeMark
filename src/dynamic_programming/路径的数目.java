package dynamic_programming;

import java.util.Arrays;

public class 路径的数目 {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] memo = new int[m][n];
        Arrays.fill(memo[0],1);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    memo[i][j] = 1;
                }else {
                    memo[i][j] = memo[i - 1][j]+memo[i][j-1];
                }
            }
        }
        return memo[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new 路径的数目().uniquePaths(3, 2));
    }
}
