package dynamic_programming;

import java.util.Arrays;

public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
//        表示以i为结尾的最长递增序列
        int memo[] = new int[nums.length];
        Arrays.fill(memo,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }
        int res = -1;
        for (int i : memo) {
            res = Math.max(res, i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 最长递增子序列().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
