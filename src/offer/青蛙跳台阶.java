package offer;

import java.util.HashMap;
import java.util.Map;

public class 青蛙跳台阶 {
    Map<Integer, Integer> cache = new HashMap<>();

    public int numWays(int n) {
        if (n == 0 || n==1) {
            return 1;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, (numWays(n - 1) + numWays(n - 2))%1000000007);
        return cache.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new 青蛙跳台阶().numWays(7));
    }
}
