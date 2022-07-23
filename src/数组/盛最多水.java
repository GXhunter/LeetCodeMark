package 数组;

/**
 * 11
 */
public class 盛最多水 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            max = Math.max(max,(right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
