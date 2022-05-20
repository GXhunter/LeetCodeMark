package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/permutations/submissions/">...</a>
 */
public class 全排列2 {
    private boolean[] used;
    private Set<List<Integer>> result = new HashSet<>();
    /**
     * [0,index)
     *
     * @param res
     * @param nums
     */
    void find( List<Integer> res, final int[] nums) {
        if (res.size() == nums.length) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                res.add(nums[i]);
                used[i] = true;
                find(res, nums);
                used[i] = false;
                res.remove(res.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        find(new ArrayList<>(), nums);
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        System.out.println(new 全排列2().permuteUnique(new int[]{1, 2, 3}));

    }
}
