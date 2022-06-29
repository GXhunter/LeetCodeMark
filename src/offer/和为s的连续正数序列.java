package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        if (target < 2) {
            return null;
        }
        List<int[]> res = new ArrayList<>();
//        [0,i)的和
        int[] pre = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            pre[i] = pre[i - 1] + i - 1;
        }
        for (int left = 1, right = 1; right < target; ) {
            int sum = pre[right + 1] - pre[left];
            if (sum < target) {
                right++;
            } else if (sum > target) {
                left++;
            } else {
                int[] t = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    t[i - left] = i;
                }
                res.add(t);
                left++;
                right++;
            }

        }
        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new 和为s的连续正数序列().findContinuousSequence(15)));
    }

}
