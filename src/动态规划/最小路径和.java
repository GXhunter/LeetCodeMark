package 动态规划;

public class 最小路径和 {
    public int minPathSum(int[][] grid) {
        memo = new Integer[grid.length][grid[grid.length - 1].length];
        return find(grid, grid.length - 1, grid[grid.length - 1].length - 1);
    }

    Integer[][] memo;

    /**
     * 表示 起始点到{i,j}距离最小值
     *
     * @param grid
     * @param i
     * @param j
     * @return
     */
    int find(final int[][] grid, int i, int j) {
        if (i == -1 || j == -1) {
            return 1000;
        }
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (memo[i][j] == null) {
            memo[i][j] = grid[i][j] + Math.min(find(grid, i - 1, j), find(grid, i, j - 1));
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new 最小路径和().minPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        }));
    }
}
