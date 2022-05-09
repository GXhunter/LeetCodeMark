package dict;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class 同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        if (chars.length != chars1.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if (!Objects.equals(map.get(chars[i]), chars1[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(chars1[i])) {
                    return false;
                }
                map.put(chars[i], chars1[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 同构字符串().isIsomorphic("foo", "bar"));
    }
}
