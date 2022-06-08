package dynamic_programming;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/coin-change/comments/">...</a>
 * F(n): 填满容量为 n 的背包最少需要的硬币数目
 * F(n) = min{F(n-coins(i))+1,F(n)}
 */
public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
//        memo[j] 表示  填满 容量为j 所需的最少硬币
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
//            遍历容量
        for (int j = 1; j <= amount; j++) {
//        遍历元素
            for (int i = 0; i < coins.length; i++) {
                if (j - coins[i] >= 0 && memo[j - coins[i]]!=Integer.MAX_VALUE) {
                    memo[j] = Math.min(memo[j - coins[i]] + 1, memo[j]);
                }
            }
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }

    public static void main(String[] args) {
        System.out.println(new 零钱兑换().coinChange(new int[]{186,419,83,408}, 6249));
    }
}
