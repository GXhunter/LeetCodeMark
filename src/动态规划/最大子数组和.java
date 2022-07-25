package 动态规划;

public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            memo[i] = memo[i - 1] > 0 ? memo[i - 1] + nums[i] : nums[i];
        }
        int max = memo[0];
        for (int i : memo) {
            max = Math.max(i, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 最大子数组和().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
