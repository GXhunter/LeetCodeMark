package 动态规划;

public class 粉刷房子 {
    public int minCost(int[][] costs) {
//        房子个数
        int n = costs.length;
//        dp[i][j]： i号房间使用j号颜色时，最少成本
        int[][] memo = new int[n][3];
        memo[0] = costs[0];
        for (int i = 1; i < n; i++) {
            memo[i][0] = costs[i][0] + Math.min(memo[i - 1][1], memo[i - 1][2]);
            memo[i][1] = costs[i][1] + Math.min(memo[i - 1][0], memo[i - 1][2]);
            memo[i][2] = costs[i][2] + Math.min(memo[i - 1][0], memo[i - 1][1]);
        }
        return min(memo[n - 1][0], memo[n - 1][1], memo[n - 1][2]);
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        System.out.println(new 粉刷房子().minCost(new int[][]{
                {17,2,17},
                {16,16,5},
                {14,3,19},
        }));
    }
}
