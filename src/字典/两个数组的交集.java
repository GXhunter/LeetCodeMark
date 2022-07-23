package 字典;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class 两个数组的交集 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> res = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                res.add(i);
            }
        }
        int[] result = new int[res.size()];
        AtomicInteger i = new AtomicInteger(0);
        res.forEach(value->{
            result[i.getAndIncrement()] = value;

        });
        return result;
    }
}
