package 递归;

import java.util.*;

public class 组合总和2 {

    int sum(List<Integer> integers) {
        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        return sum;
    }

    Set<List<Integer>> result = new HashSet<>();

    void find(int index, List<Integer> res, final int[] candidates, int target) {
        if (sum(res) == target) {
            result.add(new ArrayList<>(res));
            System.out.println("找到一个解:" + res);
            return;
        }
        if (sum(res) > target) {
            return;
        }

        if (index == candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            res.add(candidates[i]);
            find(i + 1, res, candidates, target);
            res.remove(res.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (Arrays.stream(candidates).sum() < target) {
            return new ArrayList<>(result);
        }
        find(0, new ArrayList<>(), candidates, target);
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        System.out.println(new 组合总和2().combinationSum2(
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                30));
    }
}
