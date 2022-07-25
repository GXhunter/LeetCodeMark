package 递归;

/**
 * <a href="https://leetcode.cn/problems/qiu-12n-lcof/">等差数列求和</a>
 */
public class 等差数列求和 {
    public int sumNums(int n) {
        int sum = n;
        boolean b = n > 1 && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}
