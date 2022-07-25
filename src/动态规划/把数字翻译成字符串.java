package 动态规划;

public class 把数字翻译成字符串 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        if (s.length() < 2) {
            return s.length();
        }
        int[] numMap = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            numMap[i] = s.charAt(i) - '0';
        }

//        [0,i] 可翻译成的可能性数量
        int[] memo = new int[s.length()];
        memo[0] = 1;
        memo[1] = numMap[0] * 10 + numMap[1] < 26 ? 2 : 1;
        for (int i = 2; i < s.length(); i++) {
            if (numMap[i - 1] != 0 && numMap[i - 1] * 10 + numMap[i] < 26) {
                memo[i] = memo[i - 2] + memo[i - 1];
            } else {
                memo[i] = memo[i - 1];
            }
        }
        return memo[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new 把数字翻译成字符串().translateNum(12258));
    }
}
