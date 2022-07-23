package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串 {
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        int minlength = s.length();
        int startIndex = 0;
        Map<Character, Integer> map = new HashMap<>(), targetMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        boolean find = false;
        while (right <= s.length()) {
            if (valid(map,targetMap)) {
                if (right - left < minlength) {
                    startIndex = left;
                    minlength =  right - left;
                }
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
                find = true;
            } else{
                if (right < s.length()) {
                    map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                }
                right++;
            }
        }
        return find?s.substring(startIndex, startIndex + minlength):"";
    }

    private boolean valid(Map<Character, Integer> current,Map<Character, Integer> target) {
        for (Character character : target.keySet()) {
            if (current.getOrDefault(character,-1) < target.get(character)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 最小覆盖子串().minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
