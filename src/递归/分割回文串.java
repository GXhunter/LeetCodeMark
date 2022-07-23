package 递归;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {
    private List<List<String>> result = new ArrayList<>();
    /**
     * [0,index)处理好
     *
     * @param index
     * @param res
     * @param param
     */
    void find(int index, List<String> res, final String param) {
        if (index == param.length()) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int i = index+1; i <= param.length(); i++) {
            String substring = param.substring(index, i);
            if (!isHuiWen(substring)) {
                continue;
            }
            res.add(substring);
            find(i,res,param);
            res.remove(res.size() - 1);
        }
    }

    /**
     * 是否回文数
     * @param s
     * @return
     */
    boolean isHuiWen(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


    public List<List<String>> partition(String s) {
        find(0,new ArrayList<>(),s);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new 分割回文串().partition("aab"));
    }
}
