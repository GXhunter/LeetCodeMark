package dict;

import java.util.HashSet;
import java.util.Set;

public class 存在重复元素 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new 存在重复元素().containsDuplicate(new int[]{1, 2, 3, 4}));
    }
}
