package 动态规划;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/partition-equal-subset-sum/">...</a>
 */
public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
//        背包大小
        sum /= 2;
//        dp[i][j]： 使用nums[0,i) 能否填满 j
        boolean[][] dp = new boolean[nums.length][sum + 1];
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = i == nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i] >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i-1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length - 1][sum];

    }

    public static void main(String[] args) {
        System.out.println(new 分割等和子集().canPartition(new int[]{1,2,3,5}));
    }
}
