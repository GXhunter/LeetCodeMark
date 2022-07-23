package 剑指offer;

public class 和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            }
            if (sum < target) {
                left++;
            }else {
                right--;
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {

    }
}
