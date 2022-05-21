package recursion;

import java.util.*;
import java.util.stream.Collectors;

public class 子集2 {
    Set<List<Integer>> result = new HashSet<>();
    void find(int index,List<Integer> res, final int count, final int[] nums) {
        if (res.size() == count) {
            result.add(new ArrayList<>(res));
            return;
        }
//        至少预留 k-res.seze() 个空位
        for (int i = index; i <= nums.length-(count-res.size()); i++) {
            res.add(nums[i]);
            find(i+1,res,count,nums);
            res.remove(res.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            find(0, new ArrayList<>(), i, nums);
        }
        return new ArrayList<>(result);
    }


    public static void main(String[] args) {
        System.out.println(new 子集2().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
