package array;

import java.util.Arrays;

public class 除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

//        [0,i)的累乘
        int[] left = new int[n];
//        (i,length]的累乘
        int[] right = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 除自身以外数组的乘积().productExceptSelf(
                new int[]{1, 2, 3, 4})));
    }

}
