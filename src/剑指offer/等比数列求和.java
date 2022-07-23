package 剑指offer;

/**
 * https://leetcode.cn/problems/qiu-12n-lcof/
 */
public class 等比数列求和 {
    public int sumNums(int n) {
        int sum = n;
        boolean b = n > 1 && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}
