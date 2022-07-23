package 剑指offer;

public class 区域和检索_数组不可变 {
    //    记录 [0,i) 的和
    private int memo[];

    public 区域和检索_数组不可变(int[] nums) {
        memo = new int[nums.length];
        memo[0] = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            memo[i] = memo[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return memo[right+1] - memo[left];
    }
}
