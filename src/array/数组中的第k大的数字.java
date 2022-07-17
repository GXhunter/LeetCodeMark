package array;

import java.util.Random;

/**
 * 归并排序
 */
public class 数组中的第k大的数字 {
    Random mRandom = new Random();

    int arraySize;

    public int findKthLargest(int[] nums, int k) {
        return k > (arraySize = nums.length) ?
                0 : findInRange(nums, 0, nums.length - 1, k);
    }

    /**
     * 在[from,to]里寻找nums数组第k大元素，并返回对应下标
     */
    private int findInRange(final int[] nums, int from, int to, int k) {
        int mid = partion(nums, from, to);
        if (arraySize - mid == k) {
            return nums[mid];
        } else if (arraySize - mid < k) {
            return findInRange(nums, from, mid - 1, k);
        } else if (arraySize - mid > k) {
            return findInRange(nums, mid + 1, to, k);
        }
        return 0;
    }

    /**
     * 双路快排,[from,to]
     */
    private int partion(int[] nums, int from, int to) {
        int index = mRandom.nextInt(to - from + 1) + from;
        swap(nums, from, index);
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
        System.out.println(new 数组中的第k大的数字().findKthLargest(
                new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
