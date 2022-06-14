package offer;

public class 礼物的最大价值 {
    public int maxValue(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length + 1];
        memo[0][1] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            memo[0][i + 1] = memo[0][i] + grid[0][i];
        }

//        第二行开始
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j <= grid[i].length; j++) {
                memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]) + grid[i][j - 1];
            }
        }
        return memo[grid.length - 1][grid[0].length];
    }

    public static void main(String[] args) {
        System.out.println(new 礼物的最大价值().maxValue(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        }));
    }
}
