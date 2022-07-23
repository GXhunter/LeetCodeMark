package 剑指offer;

import java.util.Random;

/**
 * 左侧二分查找+前缀数组
 */
public class 按权重随机选择 {
    int[] memo;
    int n;
    Random rand = new Random();

    public 按权重随机选择(int[] w) {
        n = w.length;
        memo = new int[n + 1];
        memo[1] = w[0];
        for (int i = 1; i < n; i++) {
            memo[i + 1] = memo[i] + w[i];
        }
    }

    public int pickIndex() {
        int target = rand.nextInt(memo[n]) + 1;
        int left = 0, right = n + 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (memo[mid] < target) {
                left = mid + 1;
            } else if (memo[mid] > target) {
                right = mid;
            } else if (memo[mid] == target) {
                right = mid;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        System.out.println(new 按权重随机选择(new int[]{1, 3}).pickIndex());
    }
}
