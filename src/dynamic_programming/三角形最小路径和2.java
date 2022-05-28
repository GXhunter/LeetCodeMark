package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划解法，从最后一行往上递推
 */
public class 三角形最小路径和2 {

    /**
     * [2,0],
     * [3,4,0],
     * [6,5,7,0],
     * [4,1,8,3,0],
     * [0,0,0,0,0,0],
     * tip: 最后一行/列 补0 可以有效避免边界判断
     *      将二维数组平铺
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n+1][n+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                memo[i][j] = Math.min(memo[i + 1][j], memo[i + 1][j + 1])
                        + triangle.get(i).get(j);
            }
        }
        return memo[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3, 4));
        lists.add(Arrays.asList(6, 5, 7));
        lists.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new 三角形最小路径和2().minimumTotal(lists));

    }

}
