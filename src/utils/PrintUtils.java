package utils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PrintUtils {
    public static void print(char[][] source) {
        for (char[] chars : source) {
            for (char aChar : chars) {
                System.out.printf("%s ", aChar);
            }
            System.out.println();
        }
    }

    public static IntStream subArrayStream(int[] nums, int from, int to) {
        int[] temp = new int[to-from];
        System.arraycopy(nums, from, temp, 0, to - from);
        return Arrays.stream(temp);
    }
}
