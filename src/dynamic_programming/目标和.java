package dynamic_programming;

import java.util.Arrays;

public class 目标和 {

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 1) {
            if (Math.abs(nums[0]) != Math.abs(target)) {
                return 0;
            }
            return target == 0 ? 2 : 1;
        }
        int sum = 0;
        int[] newArray = Arrays.copyOfRange(nums, 0, nums.length - 1);
        sum += findTargetSumWays(newArray, target - nums[nums.length - 1]);
        sum += findTargetSumWays(newArray, target + nums[nums.length - 1]);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new 目标和().findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
    }
}
