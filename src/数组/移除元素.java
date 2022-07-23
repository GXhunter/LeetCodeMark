package 数组;

/**
 * 27号问题
 */
public class 移除元素 {
    /**
     * [3,2,2,3]
     */
    public int removeElement(int[] nums, int val) {
//        循环不变量：[0,i]之间的元素有效
        int i = 0;
        for (int cursor = 0; cursor < nums.length; cursor++) {
            if (nums[cursor] == val) {
            } else {
                swap(nums, cursor, i++);
            }
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
