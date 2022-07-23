package 剑指offer;

public class 拼车 {
    public boolean carPooling(int[][] trips, int capacity) {
        int size = 10;
        int[] diff = new int[size];
        for (int[] trip : trips) {
            int k = trip[0];
            int from = trip[1];
            int to = trip[2];
            diff[from] += k;
            diff[to] -= k;
        }
        int[] res = new int[size];
        res[0] = diff[0];
        if (res[0] > capacity) {
            return false;
        }
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
            if (res[i] > capacity) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 拼车().carPooling(new int[][]{
                {9, 0, 1},
                {3, 3, 7},
        }, 3));
    }

}
