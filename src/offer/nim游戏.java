package offer;

public class nim游戏 {
    /**
     * 动态规划
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        boolean[] memo = new boolean[100];
        memo[3] = memo[1] = memo[2] = true;

        for (int i = 4; i <= n; i++) {
            memo[i % 100] = !memo[(i - 1)%100] || !memo[(i - 2)%100] || !memo[(i - 3)%100];
        }
        return memo[n % 100];
    }

    /**
     * 脑筋急转弯
     * @param n
     * @return
     */
    public boolean canWin(int n) {
        return n % 4 != 0;
    }


    public static void main(String[] args) {
        for (int i = 1348820612; i > 1348820612-20; i--) {
            System.out.println(new nim游戏().canWinNim(i)==new nim游戏().canWin(i));
        }
    }
}
