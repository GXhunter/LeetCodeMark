package 数组;

import java.util.Arrays;

public class 航班预订统计 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0] - 1;
            int end = booking[1] - 1;
            int count = booking[2];
            diff[start] += count;
            if (end + 1 < n) {
                diff[end + 1] -= count;
            }
        }
        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 航班预订统计().corpFlightBookings(new int[][]{
                {3, 3, 5},
                {1, 3, 20},
                {1, 2, 15},
        }, 3)));
    }

}
