package offer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return ' ';
        }
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count + 1);
        }
        for (Character character : map.keySet()) {
            if (map.get(character) == 1) {
                return character;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new 第一个只出现一次的字符().firstUniqChar("leetcode"));
    }
}
