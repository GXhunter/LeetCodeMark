package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class 爬楼梯 {
    Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return cache.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new 爬楼梯().climbStairs(45));
    }
}
