package offer;

import java.util.Arrays;

public class 打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n);
        int[] res = new int[max-1];
        for (int i = 1; i < max; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 打印从1到最大的n位数().printNumbers(1)));
    }
}
