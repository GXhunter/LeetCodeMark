package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三角形最小路径和 {

    public int minimumTotal(List<List<Integer>> triangle) {
        cache = new Integer[triangle.size()][triangle.get(triangle.size() - 1).size()];
        return find(triangle, 0, 0);
    }

    Integer[][] cache;

    /**
     * 表示{i,j}到底部的最小距离
     *
     * @param triangle
     * @param i
     * @param j
     * @return
     */
    private int find(final List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }
        if (cache[i][j] == null) {
            cache[i][j] = triangle.get(i).get(j) + Math.min(
                    find(triangle, i + 1, j),
                    find(triangle, i + 1, j + 1)
            );
        }
        return cache[i][j];
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3, 4));
        lists.add(Arrays.asList(6, 5, 7));
        lists.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new 三角形最小路径和().minimumTotal(lists));

    }

}
