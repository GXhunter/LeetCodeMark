package 剑指offer;

import java.util.Arrays;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
//        左闭右开区间[0,length)
        int left = 0, right = nums.length;
        if (right == 0) {
            return res;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid;
            }
        }

        if (right >= nums.length || nums[right] != target) {
            return res;
        }
        res[0] = right;
        left = 0;
        right = nums.length ;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        res[1] = left - 1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 在排序数组中查找元素的第一个和最后一个位置().searchRange(new int[]{2,2}, 2)));
    }
}
