package 动态规划;

public class 编辑距离 {
    Integer[][] memo;

    /**
     * h o u r s e
     * r o s
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        //        memo[i][j]： word[0:i)和word2[0,j)的最小编辑距离
        memo = new Integer[m + 1][n + 1];
        /*动态规划解法
//        初始化word2为空的情况
        for (int i = 0; i <= m; i++) {
            memo[i][0] = i;
        }

//        初始化word1为空的情况
        for (int i = 0; i <= n; i++) {
            memo[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else {
                    memo[i][j] = 1 + min(
//                            选择了删除
                            memo[i - 1][j],
//                            选择了新增
                            memo[i][j - 1],
//                            选择了修改
                            memo[i - 1][j - 1]
                    );
                }
            }
        }
        return memo[m][n];*/

//        记忆化搜索解法
        return minDistance(word1, m, word2, n);
    }


    /**
     * word1[0,i)与word2[0,j)的最小编辑距离
     *
     * @return
     */
    public int minDistance(String word1, int i, String word2, int j) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            memo[i][j] = minDistance(word1, i - 1, word2, j - 1);
            return memo[i][j];
        }
        memo[i][j] = 1 + min(
//                插入
                minDistance(word1, i, word2, j - 1),
//                删除
                minDistance(word1, i - 1, word2, j),
//                替换
                minDistance(word1, i - 1, word2, j - 1)
        );
        return memo[i][j];

    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        System.out.println(new 编辑距离().minDistance("horse", "ros"));
    }
}
