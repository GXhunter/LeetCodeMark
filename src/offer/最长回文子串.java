package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        List<Character>[] memo = new ArrayList[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int left = i, right = i;
                 left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right);
                 left--, right++) {
                if (left == right) {
                    memo[i] = new ArrayList<>();
                } else {
                    memo[i].add(0,s.charAt(left));
                }
                memo[i].add(s.charAt(right));
            }
        }
        int maxIndex = 0;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i].size() > memo[maxIndex].size()) {
                maxIndex = i;
            }
        }
        List<Character> characters = memo[maxIndex];
        return characters.stream()
                .map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(new 最长回文子串().longestPalindrome("cbbd"));
    }

}
