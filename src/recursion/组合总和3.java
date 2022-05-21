package recursion;

import java.util.*;

public class 组合总和3 {
    boolean[] used = new boolean[10];

    int sum(List<Integer> integers) {
        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        return sum;
    }

    Set<List<Integer>> result = new HashSet<>();

    void find(int index, List<Integer> res, final int[] candidates, int target, int k) {
        if (sum(res) == target && res.size() == k) {
            result.add(new ArrayList<>(res));
            System.out.println("找到一个解:" + res);
            return;
        }
        if (sum(res) > target || res.size()>=k) {
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
            find(i + 1, res, candidates, target, k);
            res.remove(res.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        find(0,new ArrayList<>(),nums,n,k);
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        System.out.println(new 组合总和3().combinationSum3(3, 9));
    }
}
