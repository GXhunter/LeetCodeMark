package 字典;

import java.util.HashSet;
import java.util.Set;

public class 缺失的数字 {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) {
            set.add(i);
        }
        for (int num : nums) {
            set.remove(num);
        }
        return (int) set.toArray()[0];
    }
}
