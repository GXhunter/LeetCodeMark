package offer;

import java.util.ArrayList;
import java.util.List;

public class 调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
//        奇数
        List<Integer> odd = new ArrayList<>();
//        偶数
        List<Integer> even = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            }else {
                odd.add(num);
            }
        }
        odd.addAll(even);
        return odd.stream().mapToInt(value -> value).toArray();
    }
}
