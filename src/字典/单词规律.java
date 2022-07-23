package 字典;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class 单词规律 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        char[] chars = pattern.toCharArray();
        String[] s1 = s.split(" ");
        if (chars.length != s1.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if (!Objects.equals(map.get(chars[i]), s1[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(s1[i])) {
                    return false;
                }
                map.put(chars[i], s1[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 单词规律().wordPattern("abba", "dog cat cat dog"));
    }
}
