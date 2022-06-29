package offer;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
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
    int n;

    public List<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] used = new boolean[m][n];
        List<Integer> res = new ArrayList<>();
        int offset = 0;
        int x = 0, y = 0;
        while (res.size() < m * n) {
            res.add(matrix[x][y]);
            used[x][y] = true;
            for (int i = 0; i < 4; i++, offset = (offset + 1) % 4) {
                int newx = x + offsetMap[offset][0];
                int newy = y + offsetMap[offset][1];
                if (isValid(newx, newy) && !used[newx][newy]) {
                    x = newx;
                    y = newy;
                    break;
                }
            }
        }
        return res;
    }


    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

}
