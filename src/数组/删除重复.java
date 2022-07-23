package 数组;

/**
 * 26号
 */
public class 删除重复 {
    public int removeDuplicates(int[] nums) {
//        nums[0...i)不重复
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                swap(nums, ++i, j);
            }
        }
        return  i+1;
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
