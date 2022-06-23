package offer;

import java.util.Arrays;

public class 字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0, length = s1.length();
        char[] target = s1.toCharArray();
        Arrays.sort(target);
        while (left + length <= s2.length()) {
            char[] chars = s2.substring(left, left+length).toCharArray();
            Arrays.sort(chars);
            if (Arrays.equals(chars, target)) {
                return true;
            }
            left++;
        }
        return false;
    }



}
