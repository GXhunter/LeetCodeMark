package 剑指offer;

public class 矩阵中的路径 {
    int[][] offsets = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };
    boolean[][] used;
    public boolean exist(char[][] board, String word) {
        used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    if (dsf(board, word, i, j, 0)) {
                        return true;
                    }
                    used[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dsf(char[][] board, String word, int x, int y, int index) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        if (word.length() == index + 1) {
            return board[x][y] == word.charAt(index);
        }
        if (word.charAt(index) != board[x][y]) {
            return false;
        }

        for (int[] offset : offsets) {
            int newx = x + offset[0];
            int newy = y + offset[1];
            if (!isValid(newx, newy, board)) {
                continue;
            }
            if (used[newx][newy]) {
                continue;
            }
            used[newx][newy] = true;
            if (dsf(board, word,newx , newy, index + 1)) {
                return true;
            }
            used[newx][newy] = false;
        }
        return false;
    }

    public boolean isValid(int x, int y, char[][] board) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }

    public static void main(String[] args) {
        System.out.println(new 矩阵中的路径().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
    }
}
