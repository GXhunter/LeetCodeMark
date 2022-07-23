package 字典;

import java.util.HashSet;
import java.util.Set;

public class 快乐数 {
    Set<Integer> map = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int sum = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            sum += (c - '0') * (c - '0');
        }
        if (map.contains(sum)) {
            return false;
        }
        map.add(sum);

        return isHappy(sum);
    }

    public static void main(String[] args) {
        System.out.println(new 快乐数().isHappy(7));
    }


}
