package dynamic_programming;

public class 下降路径最小和 {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
//        走到memo[i][j] 的最小距离
        int[][] memo = new int[n][n];
        memo[0] = matrix[0];
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                memo[row][col] = memo[row - 1][col];
                if (col + 1 < n) {
                    memo[row][col] = Math.min(memo[row][col], memo[row - 1][col + 1]);
                }
                if (col - 1 >= 0) {
                    memo[row][col] = Math.min(memo[row][col], memo[row - 1][col - 1]);
                }
                memo[row][col] += matrix[row][col];
            }
        }


        return min(memo[n-1]);

    }

    private int min(int... nums){
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new 下降路径最小和().minFallingPathSum(new int[][]{
                {-19,57},
                {-40,-5},
        }));
    }

}
