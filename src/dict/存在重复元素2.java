package dict;

import java.util.*;

/**
 * 滑动窗口+字典 思想
 */
public class 存在重复元素2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
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
        System.out.println(new 存在重复元素2().containsNearbyDuplicate(new int[]{1, 2, 3,1,2, 3}, 2));
//        System.out.println(new 存在重复元素2().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }
}
