package tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 基于归并排序
 * <a href="https://leetcode.cn/problems/count-of-smaller-numbers-after-self/">...</a>
 */
public class 计算右侧小于当前元素的个数 {
    int[][] temp;
    int[] result;

    public List<Integer> countSmaller(int[] nums) {
        temp = new int[nums.length][2];
        result = new int[nums.length];
        int[][] params = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            params[i] = new int[]{nums[i], i};
        }
        sortRange(params, 0, nums.length);
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    private void sortRange(final int[][] nums, int from, int to) {
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
     * @param lo  最低点
     * @param mid 中点
     * @param hi  最高点（不包含）
     */
    private void merge(final int[][] nums, int lo, int mid, int hi) {
//        拷贝范围数组元素
        if (hi - lo >= 0) System.arraycopy(nums, lo, temp, lo, hi - lo);

        int i = lo, j = mid;
        for (int index = lo; index < hi; index++) {
            if (i == mid) {
                nums[index] = temp[j++];
            } else if (j == hi) {
                nums[index] = temp[i++];
                result[nums[index][1]] += j - mid;
//                注意后等号添加的位置
            } else if (temp[j][0] < temp[i][0]) {
                nums[index] = temp[j++];
            } else if (temp[j][0] >= temp[i][0]) {
                nums[index] = temp[i++];
                result[nums[index][1]] += j - mid;
            }
        }

    }


    public static void main(String[] args) {
        System.out.println(new 计算右侧小于当前元素的个数().countSmaller(new int[]{-1, -1}));
    }
}
