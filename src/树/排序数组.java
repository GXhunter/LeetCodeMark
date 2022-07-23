package 树;

import java.util.Arrays;

/**
 * 归并排序
 */
public class 排序数组 {
    int[] temp;

    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        sortRange(nums, 0, nums.length);
        return nums;
    }

    private void sortRange(final int[] nums, int from, int to) {
        if (from == to - 1) {
            return;
        }
        int middle = (from + to) / 2;
        sortRange(nums, from, middle);
        sortRange(nums, middle, to);
        merge(nums, from, middle, to);
    }

    /**
     * 合并数组
     * [left,middle)和[middle,right)
     *
     * @param nums
     * @param left   最低点
     * @param middle 中点
     * @param right  最高点（不包含）
     */
    private void merge(final int[] nums, int left, int middle, int right) {
//        拷贝范围数组元素
        if (right - left >= 0) System.arraycopy(nums, left, temp, left, right - left);

        for (int index = left, i = left, j = middle; index < right; index++) {
            if (i >= middle) {
                nums[index] = temp[j++];
            } else if (j >= right) {
                nums[index] = temp[i++];
            } else if (temp[i] < temp[j]) {
                nums[index] = temp[i++];
            } else {
                nums[index] = temp[j++];
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 排序数组().sortArray(new int[]{5, 2, 3, 1})));
    }
}
