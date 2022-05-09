package array;

/**
 * 167
 */
public class 两数之和2 {
    /**
     * @param numbers 递增序列
     * @param target 目标值
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left+1, right+1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            }else {
                left++;
            }
        }
        return numbers;
    }
}
