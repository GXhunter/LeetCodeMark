package 动态规划;

import java.util.Arrays;

public class 打家劫舍3 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(
                solve(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                solve(Arrays.copyOfRange(nums, 1, nums.length ))
                );
    }
    public int solve(int[] nums) {
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
        System.out.println(new 打家劫舍3().rob(new int[]{1, 2, 3, 1}));
    }
}
