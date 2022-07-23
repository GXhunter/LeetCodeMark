package 递归;

import java.util.ArrayList;
import java.util.List;

public class 二进制手表 {
    int[] map = new int[]{
            60,
            60 * 2,
            60 * 2 * 2,
            60 * 2 * 2 * 2,
//            分钟
            1,
            2,
            4,
            8,
            16,
            32,
    };

    List<List<Integer>> result = new ArrayList<>();

    /**
     * 组合(index,turnedOn]
     *
     * @param index    已处理灯数
     * @param res
     * @param turnedOn
     */
    void find(int index, List<Integer> res, final int turnedOn) {
        if (res.size() == turnedOn) {
            if (res.stream().filter(e -> e >= 60).reduce(Integer::sum)
                    .orElse(0) > 11 * 60) {
                return;
            }
            if (res.stream().filter(e -> e < 60).reduce(Integer::sum)
                    .orElse(0) >59) {
                return;
            }
            result.add(new ArrayList<>(res));
            return;
        }
        for (int i = index; i < map.length; i++) {
            res.add(map[i]);
            find(i + 1, res, turnedOn);
            res.remove(res.size() - 1);
        }

    }

    public List<String> readBinaryWatch(int turnedOn) {
        find(0, new ArrayList<>(), turnedOn);
        List<String> res = new ArrayList<>();
        for (List<Integer> k : result) {
            Integer sum = k.stream().reduce(Integer::sum).orElse(0);
            int hours = sum / 60;
            int minus = sum % 60;
            if (hours < 12) {
                res.add(hours + ":" + (minus < 10 ? "0" + minus : minus));
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        new 二进制手表().readBinaryWatch(1);
    }


}
