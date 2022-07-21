package dynamic_programming;

import java.util.Arrays;

public class 跳跃游戏4 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return 0;
        }
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE);
        memo[0] = nums[0];
        for (int p = 1; p < n; p++) {
//            todo 改为滑动窗口 单调队列
            for (int i = 1; i <= k && i <= p; i++) {
                memo[p] = Math.max(memo[p - i], memo[p]);
            }
            memo[p] += nums[p];
        }
        return memo[n-1] == Integer.MIN_VALUE ? 0 : memo[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new 跳跃游戏4().maxResult(new int[]{1,-1,-2,4,-7,3}, 2));
    }
}
