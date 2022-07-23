package 字典;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i])!=null) {
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] res = new 两数之和().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(res);
    }
}
