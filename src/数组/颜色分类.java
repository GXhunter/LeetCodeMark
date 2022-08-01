package 数组;

public class 颜色分类 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
//        0： 红的个数，1白色个数，2蓝色个数
        int[] map = new int[3];
        for (int num : nums) {
            map[num] = map[num] + 1;
        }
        for (int i = 0; i < n; i++) {
            if (i < map[0]) {
                nums[i] = 0;
            } else if (i < map[0] + map[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        new 颜色分类().sortColors(new int[]{2, 0, 2, 1, 1, 0});

    }

}
