package recursion;

import java.util.ArrayList;
import java.util.List;

public class 组合 {
    List<List<Integer>> result = new ArrayList<>();
    void find(int index,List<Integer> res,final int[] nums,final int k) {
        if (res.size() == k) {
            result.add(new ArrayList<>(res));
            return;
        }
//        至少预留 k-res.seze() 个空位
        for (int i = index; i <= nums.length-(k-res.size()); i++) {
            res.add(nums[i]);
            find(i+1,res,nums,k);
            res.remove(res.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        find(0, new ArrayList<>(), nums, k);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new 组合().combine(4, 2));
    }
}
