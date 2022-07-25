package 数组;

import java.util.Arrays;

public class 螺旋矩阵2 {
    /**
     * 右、下、左、上
     */
    int[][] offsetMap = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
    };

    int m;

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        m = n;
        boolean[][] used = new boolean[n][n];
        for (int i = 0, x = 0, y = 0, offset = 0; i < n * n; i++) {
            matrix[x][y] = i + 1;
            used[x][y] = true;
            for (int f = 0; f < 4; f++, offset = (offset + 1) % 4) {
                int newx = x + offsetMap[offset][0];
                int newy = y + offsetMap[offset][1];
                if (isValid(newx, newy) && !used[newx][newy]) {
                    x = newx;
                    y = newy;
                    break;
                }
            }
        }
        return matrix;
    }


    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < m;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new 螺旋矩阵2().generateMatrix(3)));
    }

}
