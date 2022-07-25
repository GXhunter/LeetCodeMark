package 队列与栈;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class 括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String>[] memo = new ArrayList[n+1];
        memo[1] = new ArrayList<>();
        memo[1].add("()");
        for (int i = 2; i <= n; i++) {
            for (String s : memo[i - 1]) {
                if (memo[i]==null) {
                    memo[i] = new ArrayList<>();
                }
                for (int j = 0; j <= s.length(); j++) {
                    memo[i].add(new StringBuilder(s).insert(j, "()").toString());
                }
            }
        }
        return memo[n].stream().distinct().collect(Collectors.toList());
    }

    private Set<String> generate(int n) {
        Set<String> result = new HashSet<>();
        if (n == 1) {
            result.add("()");
            return result;
        }
        List<String> last = generateParenthesis(n - 1);
        for (String s : last) {
            for (int i = 0; i <= s.length(); i++) {
                result.add(new StringBuilder(s).insert(i, "()").toString());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new 括号生成().generateParenthesis(3));
    }


}
