package 动态规划;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iv/">...</a>
 */
public class 组合总和4 {
    public int combinationSum4(int[] nums, int target) {
//        填满容量为i的背包，有几种途径
        int[] memo = new int[target + 1];
        memo[0] = 1;
//            遍历背包
        for (int i = 1; i <= target; i++) {
//        遍历元素
            for (int num : nums) {
                if (i >= num) {
                    memo[i] = memo[i] + memo[i - num];
                }
            }
        }

        return memo[target];
    }

    public static void main(String[] args) {
//        System.out.println(new 组合总和4().combinationSum4(
//                new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25},
//                10));
        System.out.println(new 组合总和4().combinationSum4(
                new int[]{1, 2, 3},
                4));
    }
}
