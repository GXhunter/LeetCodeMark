package 字典;

import java.util.LinkedHashMap;

public class LRU缓存 {
    LinkedHashMap<Integer, Integer> map;
    int cap;

    public LRU缓存(int capacity) {
        cap = capacity;
        map = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        }
        map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        if (map.size() == cap) {
            Integer delKey = map.keySet().iterator().next();
            map.remove(delKey);
        }
        map.put(key, value);
    }
}
