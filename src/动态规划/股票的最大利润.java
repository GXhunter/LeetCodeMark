package 动态规划;

public class 股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
//        前 i 天的最小值
        int[] memo = new int[prices.length];
        memo[0] = prices[0];
        memo[1] = Math.min(prices[1], prices[0]);
        int max = Math.max(prices[1] - prices[0], 0);
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - memo[i - 1]);
            memo[i] = Math.min(memo[i - 1], prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 股票的最大利润().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
