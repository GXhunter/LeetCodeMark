package 数组;


/**
 * 345
 */
public class 反转元音字母 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (!isMeta(Character.toLowerCase(chars[left]))) {
                left++;
                continue;
            }
            if (!isMeta(Character.toLowerCase(chars[right]))) {
                right--;
                continue;
            }
            swap(chars, left, right);
            left++;
            right--;
        }
        return new String(chars);
    }

    public boolean isMeta(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private void swap(char[] nums, int i, int j) {
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
