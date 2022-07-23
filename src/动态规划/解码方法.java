package 动态规划;

public class 解码方法 {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] memo = new int[chars.length + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int a = chars[i - 1] == '0' ? 0 : memo[i - 1];
            int b = chars[i - 2] == '0' || s.substring(i - 2, i).compareTo("26") > 0
                    ? 0 : memo[i - 2];
            memo[i] = a + b;
        }
        return memo[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new 解码方法().numDecodings("12"));
    }
}
