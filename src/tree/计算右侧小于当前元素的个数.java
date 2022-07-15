package tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 基于归并排序
 * todo 重复元素bug
 * <a href="https://leetcode.cn/problems/count-of-smaller-numbers-after-self/">...</a>
 */
public class 计算右侧小于当前元素的个数 {
    Pair[] temp;
    int[] result;

    private class Pair {
        int val, id;
        Pair(int val, int id) {
            // 记录数组的元素值
            this.val = val;
            // 记录元素在数组中的原始索引
            this.id = id;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        temp = new Pair[nums.length];
        result = new int[nums.length];
        Pair[] params = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            params[i] = new Pair(nums[i],i);
        }
        sortRange(params, 0, nums.length);
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    private void sortRange(final Pair[] nums, int from, int to) {
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
     * @param lo   最低点
     * @param mid 中点
     * @param hi  最高点（不包含）
     */
    private void merge(final Pair[] nums, int lo, int mid, int hi) {
//        拷贝范围数组元素
        if (hi - lo >= 0) System.arraycopy(nums, lo, temp, lo, hi - lo);

        int i = lo, j = mid;
        for (int index = lo; index < hi; index++) {
            if (i == mid) {
                nums[index] = temp[j++];
            } else if (j == hi) {
                nums[index] = temp[i++];
                result[nums[index].id] += j - mid;
            } else if (temp[i].val < temp[j].val) {
                nums[index] = temp[i++];
                result[nums[index].id] += j - mid;
            } else {
                nums[index] = temp[j++];
            }
        }

    }


    public static void main(String[] args) {
        System.out.println(new 计算右侧小于当前元素的个数().countSmaller(new int[]{-1,-1}));
    }
}
