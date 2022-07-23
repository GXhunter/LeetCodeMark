package 剑指offer;

public class 回文数 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);

        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
