package 字典;

import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-iii/">https://leetcode.cn/problems/contains-duplicate-iii/</a>
 * 滑动窗口+字典 思想
 */
public class 存在重复元素3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer less = set.floor(nums[i]);
            if (less != null && (long)nums[i] - (long)less <= t) {
                return true;
            }
            Integer more = set.ceiling(nums[i]);
            if (more != null && (long)more - (long)nums[i] <= t) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new 存在重复元素3().containsNearbyAlmostDuplicate(new int[]{-2147483648,2147483647}, 1, 1));
    }
}
