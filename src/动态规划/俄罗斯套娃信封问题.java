package 动态规划;

import java.util.Arrays;

/**
 * 普通动态规划+lis已经无法通过LeetCode全部测试用例了，要使用耐心排序nlogn级别的解法
 */
public class 俄罗斯套娃信封问题 {
    public int maxEnvelopes(int[][] envelopes) {
//        按宽度升序，相同宽度按高度降序。
//        相同w按高度降序的目的是让相同的w不会组成嵌套（w相同时，无论h多少都无法嵌套）。
        Arrays.sort(envelopes, (o1, o2) ->
                o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]
        );
        int n = envelopes.length;
        int[] memo = new int[n];
        Arrays.fill(memo, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }
        int max = memo[0];
        for (int i : memo) {
            max = Math.max(i, max);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new 俄罗斯套娃信封问题().maxEnvelopes(new int[][]{
                {1,1},
                {1,1},
                {1,1},
        }));
    }
}
