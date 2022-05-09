package array;

/**
 * 125
 */
public class 回文串 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0;
        int right = chars.length-1;
        boolean res = false;
        while (left <= right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
                res = true;
            } else if  (!((chars[left] >= '0' && chars[left] <= '9') || (chars[left] >= 'a' && chars[left] <= 'z')) ){
                left++;
            } else if (!((chars[right] >= '0' && chars[right] <= '9') || (chars[right] >= 'a' && chars[right] <= 'z')) ) {
                right--;
            }else {
                return false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new 回文串().isPalindrome("0P");
    }
}