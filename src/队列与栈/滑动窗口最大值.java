package 队列与栈;

import java.util.Arrays;

public class 滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        MonotonicQueue window = new MonotonicQueue();
        for (int i = 0; i < k - 1; i++) {
            window.push(nums[i]);
        }

        for (int i = k - 1; i < n; i++) {
            if (i - k >= 0) {
                window.removeFirst(nums[i - k]);
            }
            window.push(nums[i]);
            res[i - k + 1] = window.maxValue();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 滑动窗口最大值().maxSlidingWindow(new int[]{
                1,3,-1,-3,5,3,6,7
        }, 3)));
    }

}
