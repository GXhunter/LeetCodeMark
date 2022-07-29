package 动态规划;

public class 两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        int n = lcs(word1, word2);
        return word1.length() - n + word2.length() - n;
    }

    /**
     * 动态规划的lcs
     * @param word1
     * @param word2
     * @return
     */
    private int lcs(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
//        dp[j][j]表示 word1[0:i)与word2[0:j)的最大公共子串
//        动态转移方程dp[i][j] = word1[i]==word2[j]
//          ? 1 + dp[i-1][j-1] : max(dp[i][j-1],dp[i-1][j],dp[i-1][j-1])
        int[][] dp = new int[m + 1][n + 1];
//        base dp[0][n] = 0
//        base dp[m][0] = 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];

    }

    public static void main(String[] args) {
        System.out.println(new 两个字符串的删除操作().lcs("sea", "eat"));
    }
}
