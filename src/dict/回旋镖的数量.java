package dict;

import java.util.HashMap;
import java.util.Map;

public class 回旋镖的数量 {
//     todo 暂未通过
    public int numberOfBoomerangs(int[][] points) {
//        距离i平方
        Map<Integer, Integer> distance = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
//            todo
            for (int j = i + 1; j < points.length; j++) {
                if (i != j) {
                    int dis = (points[j][0] - points[i][0]) * (points[j][0] - points[i][0]) +
                            (points[j][1] - points[i][1]) * (points[j][1] - points[i][1]);
                    distance.putIfAbsent(dis, 0);
                    distance.put(dis, distance.get(dis) + 1);

                }
            }
        }

        return distance.values().stream().filter(e -> e > 2).map(e -> e * (e - 1)).reduce(Integer::sum).orElse(0);
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
