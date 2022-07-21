package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 最少的硬币数目 {
    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        return 动态规划(coins, amount);
    }

    /**
     * dp[amount] = min(dp[amount-coins[i]])+1
     *
     * @param coins
     * @param amount
     * @return
     */
    private int 动态规划(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && memo[i - coin] != Integer.MAX_VALUE) {
                    memo[i] = Math.min(memo[i - coin], memo[i]);
                }
            }
            if (memo[i] != Integer.MAX_VALUE) {
                memo[i]++;
            }
        }
        return memo[amount]==Integer.MAX_VALUE?-1:memo[amount];
    }


    /**
     * 凑出amount最少需要的硬币数量
     *
     * @param coins
     * @param amount
     * @return
     */
    private int 记忆化搜索(int[] coins, int amount) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int i = coinChange(coins, amount - coin);
            if (i == -1) {
                continue;
            }
            res = Math.min(i, res);
        }
        memo.put(amount, res == Integer.MAX_VALUE ? -1 : res + 1);
        return memo.get(amount);
    }

    public static void main(String[] args) {
        System.out.println(new 最少的硬币数目().coinChange(new int[]{2, 5, 10, 1}, 27));
    }
}
