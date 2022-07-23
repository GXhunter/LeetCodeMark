package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class 斐波那契数列 {
    Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, (fib(n - 1) + fib(n - 2))%1000000007);
        return cache.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new 斐波那契数列().fib(45));
    }
}
