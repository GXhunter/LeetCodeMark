package dynamic_programming;

/**
 * <a href="https://leetcode.cn/problems/house-robber/">...</a>
 * 记忆化搜索方式
 */
public class 打家劫舍 {
    Integer[] memo;

    public int rob(int[] nums) {
        memo = new Integer[nums.length];
        return find(nums, 0);
    }

    /**
     * 获取 (index,nums.length-1) 范围能盗取的最大值
     * @param nums
     * @param index
     * @return
     */
    private int find(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] == null) {
            int max = -1;
            for (int i = index; i < nums.length; i++) {
                max = Math.max(nums[i] + find(nums, i + 2), max);
            }
            memo[index] = max;
        }
        return memo[index];
    }

    public static void main(String[] args) {
        System.out.println(new 打家劫舍().rob(new int[]{2, 7, 9, 3, 1}));
    }
}
