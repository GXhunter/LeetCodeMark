package 数组;

public class 旋转图像 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                swap(matrix, i, j);
            }
        }
        for (int[] ints : matrix) {
            for (int j = 0; j < m / 2; j++) {
                swapRow(ints, j, m - j - 1);
            }
        }
    }

    private void swapRow(int[] matrix, int i, int j) {
        int temp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = temp;
    }
    private void swap(int[][] matrix, int x, int y) {
        int temp = matrix[x][y];
        matrix[x][y] = matrix[y][x];
        matrix[y][x] = temp;
    }

    public static void main(String[] args) {
        new 旋转图像().rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        });
    }

}
