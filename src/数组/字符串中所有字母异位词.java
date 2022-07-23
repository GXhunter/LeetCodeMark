package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438
 */
public class 字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        int[] target = new int[26];
        for (char c : p.toCharArray()) {
            target[c - 'a']++;
        }
        for (int index = 0; index <= chars.length - p.length(); index++) {
            int[] source = new int[26];
            for (int i = index; i < index + p.length(); i++) {
                source[chars[i]-'a']++;
            }
            if (Arrays.equals(target,source)) {
                res.add(index);
            }
        }

        return res;
    }

    private boolean isValid(char[] sources, int start, int end, char[] target) {
        a:
        for (char t : target) {
            for (int i = start; i < end; i++) {
                if (sources[i] == t) {
                    continue a;
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 字符串中所有字母异位词().findAnagrams("ababababab", "aab"));
    }
}
