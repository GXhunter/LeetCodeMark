package dict;

import java.util.Arrays;

public class 有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (char c : s.toCharArray()) {
            map1[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            map2[c - 'a']++;
        }
        return Arrays.equals(map1, map2);
    }

    public static void main(String[] args) {
        System.out.println(new 有效的字母异位词().isAnagram("anagram", "nagaram"));
    }
}
