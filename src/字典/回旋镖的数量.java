package 字典;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class 回旋镖的数量 {
    //     todo 暂未通过
    public int numberOfBoomerangs(int[][] points) {
//        距离i平方
        AtomicInteger res = new AtomicInteger();
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> distance = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dis = (points[j][0] - points[i][0]) * (points[j][0] - points[i][0]) +
                            (points[j][1] - points[i][1]) * (points[j][1] - points[i][1]);
                    distance.putIfAbsent(dis, 0);
                    distance.put(dis, distance.get(dis) + 1);
                }
            }
            distance.values().stream().map(e -> e * (e - 1)).forEach(e -> res.set(res.get() + e));
        }

        return res.get();
    }

    public static void main(String[] args) {
        System.out.println(new 回旋镖的数量().numberOfBoomerangs(new int[][]{
                {0, 0},
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1},
        }));
    }
}
