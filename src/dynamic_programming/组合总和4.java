package dynamic_programming;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iv/">...</a>
 */
public class 组合总和4 {
    public int combinationSum4(int[] nums, int target) {
//        填满容量为i的背包，有几种途径
        int[] memo = new int[target + 1];
        memo[0] = 0;
        for (int i = 1; i < target; i++) {
            memo[i] = i % nums[0] == 0 && i >= nums[0] ? 1 : 0;
        }
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    memo[i] = memo[i] + 1;
                }
                if (i > nums[j]) {
                    if (memo[i - nums[j]] != 0) {
                        memo[i] = memo[i] + 1;
                    }
                }
            }
            System.out.println("背包容量为"+i);
            System.out.println(Arrays.stream(memo).boxed().map(Object::toString).collect(Collectors.joining(",")));
            System.out.println();
        }
        return memo[target];
    }

    public static void main(String[] args) {
        System.out.println(new 组合总和4().combinationSum4(
                new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25},
                10));
    }
}
