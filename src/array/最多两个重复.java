package array;

/**
 * 80号
 */
public class 最多两个重复 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
//        [0...i]有效
        int i = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != nums[i] || nums[j] != nums[i - 1]) {
                swap(nums, ++i, j);
            }
        }
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        new 最多两个重复().removeDuplicates(new int[]{1, 2, 2});
    }
}
