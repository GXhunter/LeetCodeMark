package 动态规划;

public class 房屋偷盗 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
//        dp[i] :盗取0...i号房间能获取的最大收益
//        dp[i][0]: 不盗取第i号房
//        dp[i][1]: 一定盗取第i号房
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i % 2][1] = dp[(i - 1) % 2][0] + nums[i];
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][1], dp[(i - 1) % 2][0]);
        }
        return Math.max(dp[(n - 1) % 2][0], dp[(n - 1) % 2][1]);
    }

    public static void main(String[] args) {
        System.out.println(new 房屋偷盗().rob(new int[]{2, 7, 9, 3, 1}));
    }
}
