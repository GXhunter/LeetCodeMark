package 剑指offer;

import java.util.Arrays;

public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0 || matrix[0].length==0) {
            return false;
        }
        for (int[] ints : matrix) {
            if (ints[0] > target || ints[ints.length - 1] < target) {
                continue;
            }
            if (Arrays.binarySearch(ints, target) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new 二维数组中的查找().findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        }, 5));
    }
}
