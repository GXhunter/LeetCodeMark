package 递归;

/**
 * <a href="https://leetcode.cn/problems/word-search/submissions/">...</a>
 */
public class 单词搜索 {
    int offset[][] = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };
    int m, n;
    boolean[][] used;

    private boolean isvalid(int x, int y) {
        return x < m && x >= 0 && y >= 0 && y < n
                && !used[x][y];
    }

    private boolean searchFrom(char[][] board, String word, int x, int y, int index) {
        if (index == word.length()) {
            return true;
        }
        if (board[x][y] == word.charAt(index)) {
            if (index == word.length() - 1) {
                return true;
            }
            used[x][y] = true;
//            四个方向寻找下一个节点
            for (int i = 0; i < 4; i++) {
                int newx = x + offset[i][0];
                int newy = y + offset[i][1];
                if (isvalid(newx, newy) && searchFrom(board, word, newx, newy, index + 1)) {
                    return true;
                }
            }
            used[x][y] = false;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        used = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchFrom(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'A'},
        };
        System.out.println(new 单词搜索().exist(chars, "A"));
    }
}
