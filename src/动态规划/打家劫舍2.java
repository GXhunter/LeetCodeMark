package 动态规划;

/**
 * <a href="https://leetcode.cn/problems/house-robber/">...</a>
 * 动态规划方式
 */
public class 打家劫舍2 {

    public int rob(int[] nums) {
//        盗取(0,i) 的最大收益
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        if (nums.length < 2) {
            return memo[nums.length-1];
        }
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            memo[i] = Math.max(nums[i] + memo[i - 2],memo[i-1]);
        }
        return memo[nums.length-1];
    }


    public static void main(String[] args) {
        System.out.println(new 打家劫舍2().rob(new int[]{2, 7, 9, 3, 1}));
    }
}
