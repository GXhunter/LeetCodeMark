package 动态规划;

public class 最长公共子序列 {
    Integer[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new Integer[text1.length()][text2.length()];
        return 递归(text1, 0, text2, 0);
    }


    /**
     * 记忆化搜索方式
     * text1[i:]与text2[j:]最长公共子串
     */
    private int 递归(String text1, int i, String text2, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + 递归(text1, i + 1, text2, j + 1);
        } else {
            memo[i][j] = Math.max(
//                    删掉text1[i]字符后继续匹配
                    递归(text1, i + 1, text2, j),
//                    删掉text2[j]字符后继续匹配
                    递归(text1, i, text2, j + 1)
            );
        }
        return memo[i][j];
    }


    public static void main(String[] args) {
        System.out.println(new 最长公共子序列().longestCommonSubsequence("abcde", "ace"));
    }
}
