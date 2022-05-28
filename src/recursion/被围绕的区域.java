package recursion;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class 被围绕的区域 {
    /**
     * 上右下左
     */
    private final int OFFSET[][] = new int[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1},
    };
    int m, n;
    boolean[][] used;

    private boolean isvalid(int x, int y) {
        return x < m && x >= 0 && y >= 0 && y < n;
    }


    private boolean find(char[][] board, int x, int y, final List<int[]> res,boolean[][] temp) {
        if (board[x][y] != 'O') {
            return false;
        }
        temp[x][y] = true;
        boolean b = true;
        for (int i = 0; i < 4 && b; i++) {
            int newx = x + OFFSET[i][0];
            int newy = y + OFFSET[i][1];
            if (!isvalid(newx, newy)) {
                return board[x][y] != 'O';
            }
            if (used[newx][newy]) {
                return false;
            }
            if (!temp[newx][newy]) {
                if (board[newx][newy] == 'O') {
                    b &= find(board, newx, newy, res,temp);
                }
            }
        }
        if (b) {
            res.add(new int[]{x, y});
        }
        return b;
    }

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        used = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                List<int[]> result = new ArrayList<>();
                if (!used[i][j]) {
                    find(board, i, j, result,new boolean[board.length][board[0].length]);
                    reverse(board, result);
                }
            }
        }
    }

    void reverse(char[][] board, List<int[]> accr) {
        for (int[] item : accr) {
            board[item[0]][item[1]] = 'X';
            used[item[0]][item[1]] = true;
        }
    }

    public static void main(String[] args) {
      /*  char[][] chars = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };*/
        char[][] chars = {
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'},
        };
        new 被围绕的区域().solve(chars);
        PrintUtils.print(chars);
    }
}
