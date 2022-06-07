package dynamic_programming;

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
//        背包容量
        int C = sum / 2;
        int n = nums.length;
/*
        n 个物品填满 容量为C的背包
        F(n,C) = F(n-1,C)||F(n-1,C-w(i))
 */
        boolean[][] memo = new boolean[n][C + 1];
        for (int i = 0; i <= C; i++) {
            memo[0][i] = nums[0] == i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                    memo[i][j] = memo[i - 1][j] || (j - nums[i]>0 && memo[i - 1][j - nums[i]]);
            }
        }
        return memo[n-1][C];
    }

    public static void main(String[] args) {
        System.out.println(new 分割等和子集().canPartition(new int[]{1, 5, 11, 5}));
    }
}
