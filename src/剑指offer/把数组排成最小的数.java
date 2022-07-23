package 剑指offer;

import java.util.Arrays;

public class 把数组排成最小的数 {
    public String minNumber(int[] nums) {
        return Arrays.stream(nums).boxed().map(String::valueOf)
                .sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1))
                .reduce((a, b) -> a + b).get();
    }

    public static void main(String[] args) {
        System.out.println(new 把数组排成最小的数().minNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
