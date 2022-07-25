package 字典;

import java.util.HashSet;
import java.util.Set;

public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            }else {
                set.add(num);
            }
        }
        return (int) set.toArray()[0];
    }
}
