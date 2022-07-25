package 数据结构;

import java.util.Arrays;

public class 堆排序 {
    public void sort(int[] nums) {
        MapHeap heap = new MapHeap(Arrays.stream(nums).boxed().toArray(Integer[]::new));
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            nums[n - i - 1] = heap.pop();
        }
    }

    public static void main(String[] args) {
        int[] data = {15, 17, 19, 13, 22, 16, 28, 30, 41, 62};
        new 堆排序().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
