package recursion;

import java.util.ArrayList;
import java.util.List;

public class 复原IP地址 {
    public List<String> restoreIpAddresses(String s) {
        findNext(0, new ArrayList<>(), s);
        return result;
    }

    private List<String> result = new ArrayList<>();

    /**
     * @param index  [0,index)已组合完成
     * @param res
     * @param params 原始参数
     */
    void findNext(int index, List<String> res, final String params) {
        if (res.size() > 4) {
            return;
        }
        if (res.size() == 4) {
            if (index == params.length()) {
                result.add(String.join(".", res));
            }
            return;
        }
        for (int i = index + 1; i <= params.length(); i++) {
            String substring = params.substring(index, i);
            if (substring.startsWith("0") && substring.length()>1) {
                continue;
            }
            long num = Long.parseLong(substring);
            if (num >= 0 && num <= 255) {
                res.add(String.valueOf(num));
                findNext(i, res, params);
                res.remove(res.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new 复原IP地址().restoreIpAddresses("0000"));
    }

}
