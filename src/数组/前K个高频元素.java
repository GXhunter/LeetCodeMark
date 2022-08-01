package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 前K个高频元素 {
    class C {
        int val;
        int count;

        public C(int val) {
            this.val = val;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        int n = nums.length;
        if (k > n) {
            return nums;
        }
        Map<Integer, C> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new C(num));
            }
            C c = map.get(num);
            c.count = c.count + 1;
            map.put(num, c);
        }
        PriorityQueue<C> queue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        queue.addAll(map.values());
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            res[i] = queue.poll().val;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 前K个高频元素().topKFrequent(new int[]{3, 0, 1, 0}, 1)));
    }
}
