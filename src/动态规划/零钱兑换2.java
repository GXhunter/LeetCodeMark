package 动态规划;

public class 零钱兑换2 {
    /**
     * @param amount 背包
     * @param coins  元素
     * @return
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
//        dp[i][j]: 使用coins[0,i]填满 j 容量的背包有几种方法
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }

//        遍历元素
        for (int i = 1; i < n; i++) {

//            遍历背包
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[i][j] = dp[i][j - coins[i]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][amount];
    }

    public static void main(String[] args) {
        System.out.println(new 零钱兑换2().change(5, new int[]{1, 2, 5}));
    }

}
