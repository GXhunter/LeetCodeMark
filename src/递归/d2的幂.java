package 递归;

public class d2的幂 {
    public boolean isPowerOfTwo(int n) {
        if (n <1 ) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }
}
