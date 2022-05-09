package dict;

import java.util.*;

public class 根据字符出现频率排序 {
    public String frequencySort(String s) {
        java.util.SortedMap<Character, Integer> map = new TreeMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],map.getOrDefault(chars[i], 0) + 1);
        }
        ArrayList<Map.Entry<Character, Integer>> res = new ArrayList<>(map.entrySet());
        res.sort((o1, o2) -> -(o1.getValue() - o2.getValue()));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> re : res) {
            for (Integer i = 0; i < re.getValue(); i++) {
                sb.append(re.getKey());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new 根据字符出现频率排序().frequencySort("tree"));
    }
}
