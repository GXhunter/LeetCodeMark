package 剑指offer;

public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
//        以(0,i]的最大和
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            memo[i] = Math.max(nums[i], nums[i]+memo[i-1]);
        }
        int max = memo[0];
        for (int i : memo) {
            max = Math.max(i, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 连续子数组的最大和().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
