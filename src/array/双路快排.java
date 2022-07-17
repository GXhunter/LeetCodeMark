package array;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 */
public class 双路快排 {
    Random mRandom = new Random();
    public int[] sortArray(int[] nums) {
        sortRange(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortRange(final int[] nums, int from, int to) {
        if (from >= to) {
            return;
        }
        int mid = partion(nums, from, to);
        sortRange(nums, from, mid - 1);
        sortRange(nums, mid + 1, to);
    }

    /**
     * 双路快排,[from,to]
     */
    private int partion(int[] nums, int from, int to) {
        int randomIndex = mRandom.nextInt(to - from + 1) + from;
        swap(nums,from,randomIndex);
        int p = nums[from];
        int i = from + 1, j = to;
//        循环不变式：[from+1,i)<p，(j,to]>p
//        >= 最后一轮，i==j都指向一个未知大小的元素，需要调整一个i+1或者j-1才能满足上述循环不变量
        while (i <= j) {
            while (i <= to && nums[i] <= p) {
                i++;
            }
            while (j >= from + 1 && nums[j] >= p) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, from, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 双路快排().sortArray(new int[]{2, 5, 2, 3, 1})));
    }
}
