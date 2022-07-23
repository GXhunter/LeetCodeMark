package 剑指offer;

import java.util.HashSet;
import java.util.Set;

public class 数组中重复的数字 {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
