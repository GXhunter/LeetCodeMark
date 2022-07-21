package dynamic_programming;

import java.util.Arrays;
import java.util.List;

public class 单词拆分 {
    Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length() + 1];
        return 动态规划(s, s.length(), wordDict);
    }

    /**
     * dp[index] = dp[index-dict.length]
     *
     * @param s
     * @param index
     * @param wordDict
     * @return
     */
    private boolean 动态规划(String s, int index, List<String> wordDict) {
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String dict : wordDict) {
                if (dict.length() > i) {
                    continue;
                }
                if (s.substring(i - dict.length(), i).equals(dict)) {
                    memo[i] |= memo[i - dict.length()];
                }
                if (memo[i]) {
                    break;
                }
            }
        }
        return memo[s.length()];
    }

    /**
     * 给定的字典，能否拼出s[0,index)
     *
     * @param s
     * @param index
     * @param wordDict
     * @return
     */
    private boolean 记忆化搜索(String s, int index, List<String> wordDict) {
        if (memo[index] != null) {
            return memo[index];
        }
        if (index == 0) {
            memo[index] = true;
            return memo[index];
        }
        for (String dict : wordDict) {
            if (index < dict.length() || !s.substring(index - dict.length(), index).equals(dict)) {
                continue;
            }
            if (记忆化搜索(s, index - dict.length(), wordDict)) {
                memo[index] = true;
                return memo[index];
            }
        }
        memo[index] = false;
        return memo[index];
    }

    public static void main(String[] args) {
        System.out.println(new 单词拆分().wordBreak("catsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
