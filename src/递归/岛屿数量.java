package 递归;

public class 岛屿数量 {
    int offset[][] = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };
    int m, n;
    boolean[][] used;

    void floodfill(final char[][] grid,int x,int y) {
        used[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + offset[i][0];
            int newy = y + offset[i][1];
            if (isvalid(newx, newy) && grid[newx][newy]=='1') {
                floodfill(grid, newx, newy);
            }
        }
    }
    private boolean isvalid(int x, int y) {
        return x < m && x >= 0 && y >= 0 && y < n
                && !used[x][y];
    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!used[i][j] && grid[i][j] == '1') {
                    res++;
//                    染色
                    floodfill(grid, i, j);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 岛屿数量().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }
}
