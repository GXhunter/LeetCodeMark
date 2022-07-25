package 字典;

import java.util.LinkedHashMap;

public class 最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int start = 0;
        int end = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        int max = -1;

        while (end < s.length()) {
            Character c = s.charAt(end);
            if (map.containsKey(c)) {
                max = Math.max(max, end - start);
                start = map.get(c) + 1;
                if (end < start) {
                    end = start;
                }
                map.remove(map.keySet().toArray()[0]);
            } else {
                max = Math.max(max, end - start + 1);
                map.put(c, end++);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 最长不含重复字符的子字符串().lengthOfLongestSubstring(" "));
    }
}
