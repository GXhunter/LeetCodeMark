package 动态规划;

import java.util.Arrays;

public class 加减的目标值 {

    /**
     * sum(a): 正数和，sum(b) 负数和
     * sum(a)-sum(b) = target
     * 2*sum(a) = target + sum
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
//        背包
        int C = sum + target;
        if (C % 2 != 0) {
            return 0;
        }
        C /= 2;
        int n = nums.length;
        int[] dp = new int[C + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = C; j >= 0; j--) {
                if (j - nums[i - 1] >= 0) {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[C];
    }


    public static void main(String[] args) {
        System.out.println(new 加减的目标值().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
