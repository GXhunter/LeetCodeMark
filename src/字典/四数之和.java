package 字典;

import java.util.*;

public class 四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        Collections.sort(integers);
                        res.add(integers);
                        right--;
                        left++;
                    }

                }

            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        System.out.println(new 四数之和().fourSum(new int[]{2, 2, 2, 2, 2},
                8));
    }
}
