package array;

import java.util.Arrays;
import java.util.HashMap;

public class 最小覆盖子串 {
//     todo 待定
    public String minWindow(String s, String t) {

        int left = 0;
        int right = -1;
        HashMap<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c,target.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (!target.containsKey(s.charAt(i))) {
                continue;
            }
            HashMap<Character, Integer> source = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                if (target.containsKey(s.charAt(j))) {
                    target.put(s.charAt(j),target.getOrDefault(s.charAt(j), 0) + 1);
                }
            }
        }
        return new String(s.toCharArray(), left, right - left + 1);
    }

    public static void main(String[] args) {
        System.out.println(new 最小覆盖子串().minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}
