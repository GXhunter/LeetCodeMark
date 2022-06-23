package offer;

import java.util.Arrays;

public class 扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        int[] ints = Arrays.stream(nums).sorted().filter(i -> i != 0).distinct().toArray();
        long count1 = Arrays.stream(nums).filter(i -> i == 0).count();
        return 5-ints.length == count1 && ints[ints.length-1]-ints[0]<=4;
    }

    public static void main(String[] args) {
        System.out.println(new 扑克牌中的顺子().isStraight(new int[]{1,2,3,4,5}));
    }
}
