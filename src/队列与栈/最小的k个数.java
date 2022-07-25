package 队列与栈;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 最小的k个数 {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = Arrays.stream(arr).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 最小的k个数().smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }
}
