package 动态规划;

public class 背包 {
    public int knapsack01(int[] w, int[] v, int C) {
//        元素个数
        int n = w.length;
//        memo[i][j] 容量为 i 时，尝试容纳前 j 个 元素最大值
        int[][] memo = new int[C + 1][n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                for (int j = 0; j <= C; j++) {
                    if (w[i] <= j) {
                        memo[j][i] = v[i];
                    } else {
                        memo[j][i] = 0;
                    }
                }
                continue;
            }
            for (int j = 1; j <= C; j++) {
                if (w[i] > j) {
                    memo[j][i] = memo[j][i-1];
                }else {
                    memo[j][i] = Math.max(v[i] + memo[j-w[i]][i-1],memo[j][i-1]);
                }
            }
        }
        return memo[C][w.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new 背包().knapsack01(new int[]{1, 2, 3}, new int[]{6, 10, 12}, 5));
    }
}
