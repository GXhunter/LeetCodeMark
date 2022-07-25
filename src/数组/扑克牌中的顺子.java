package 数组;

import java.util.Arrays;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 链接：<a href="https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof">...</a>
 */
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
