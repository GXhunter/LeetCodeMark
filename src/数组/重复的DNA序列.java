package 数组;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 重复的DNA序列 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Long> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'A':
                    nums[i] = 1;
                    break;
                case 'C':
                    nums[i] = 2;
                    break;
                case 'G':
                    nums[i] = 3;
                    break;
                case 'T':
                    nums[i] = 4;
                    break;
            }
        }
        Long windowHashValue = 0L;
//        10^9
        long pow = ((long) Math.pow(10, 9));
        int left = 0, right = 0;
        while (right < n) {
            windowHashValue = windowHashValue * 10 + nums[right];
            right++;
            if (right - left == 10) {
//                窗口大小为10
                if (set.contains(windowHashValue)) {
                    res.add(s.substring(left, right));
                } else {
                    set.add(windowHashValue);
                }
//                    移除最高位
                windowHashValue = windowHashValue - pow * nums[left];
                left++;
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        System.out.println(new 重复的DNA序列().findRepeatedDnaSequences(
                "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
        ));
    }
}
