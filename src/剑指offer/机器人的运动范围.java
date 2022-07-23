package 剑指offer;

public class 机器人的运动范围 {
    int[][] offsets = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };
    int m, n;

    public boolean isValid(int x, int y, int k) {
        int sum = 0;
        for (char c : String.valueOf(x).toCharArray()) {
            sum += c - '0';
        }
        for (char c : String.valueOf(y).toCharArray()) {
            sum += c - '0';
        }
        return sum <= k && x >= 0 && y >= 0 && x < m && y < n;
    }

    boolean[][] used;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        used = new boolean[m][n];
        return dsf(0, 0, k);
    }


    /**
     * 从(x,y)坐标开始走，能够达到几个格子
     *
     * @param x
     * @param y
     * @param k
     * @return
     */
    private int dsf(int x, int y, int k) {
        int count = 0;
        used[x][y] = true;
        for (int[] offset : offsets) {
            int newx = x + offset[0];
            int newy = y + offset[1];
            if (!isValid(newx, newy, k) || used[newx][newy]) {
                continue;
            }
            count += dsf(newx, newy, k);
        }
        return count + 1;
    }


    public static void main(String[] args) {
        System.out.println(new 机器人的运动范围().movingCount(2, 3, 1));
    }
}
