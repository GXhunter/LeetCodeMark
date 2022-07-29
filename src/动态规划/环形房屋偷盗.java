package 动态规划;

public class 环形房屋偷盗 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(
                rob(nums, 0, nums.length - 1),
                rob(nums, 1, nums.length)
        );
    }

    /**
     * 盗取[i,j)范围内的房子
     *
     * @param nums
     * @param i
     * @param j
     * @return
     */
    private int rob(int[] nums, int i, int j) {
        int n = j - i;
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return nums[i];
        }
//        dp[i] :盗取0...i号房间能获取的最大收益
        int[] dp = new int[n];
        dp[0] = nums[i];
        dp[1] = Math.max(nums[i], nums[i + 1]);
        for (int x = i + 2; x < j; x++) {
            dp[x - i] = Math.max(dp[x - i - 2] + nums[x], dp[x - i - 1]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new 环形房屋偷盗().rob(new int[]{1, 7, 9, 2}));
    }
}
