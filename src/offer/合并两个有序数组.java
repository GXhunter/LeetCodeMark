package offer;

public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int[] res = new int[m + n];
        for (int index = 0, i = 0, j = 0; i < m || j < n; index++) {
            if (j>=n||i < m && nums1[i] < nums2[j]) {
                res[index] = nums1[i];
                i++;
            } else {
                res[index] = nums2[j];
                j++;
            }
        }
        System.arraycopy(res, 0, nums1, 0, nums1.length);
    }

    public static void main(String[] args) {
        new 合并两个有序数组().merge(new int[]{2,0}, 1, new int[]{1}, 1);
    }
}
