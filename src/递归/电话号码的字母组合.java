package 递归;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {
    private final static String[] map = new String[]{
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
    };
    private final List<String> res = new ArrayList<>();

    /**
     * @param completed 已完成部分 [0,index)
     * @param digits    原始参数
     * @param index     [index,$length-1]未完成部分
     */
    private void find(String completed, final String digits, int index) {
        if (index == digits.length()) {
            res.add(completed);
            return;
        }
        String chars = map[digits.charAt(index) - '0'];
        for (int i = 0; i < chars.length(); i++) {
            find(completed+=chars.charAt(i), digits, index + 1);
            completed = completed.substring(0, completed.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        find("",digits,0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 电话号码的字母组合().letterCombinations("23"));
    }
}
