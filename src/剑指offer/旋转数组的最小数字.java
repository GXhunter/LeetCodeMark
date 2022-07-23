package 剑指offer;

public class 旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    public static void main(String[] args) {
        System.out.println(new 旋转数组的最小数字().minArray(new int[]{2,2,2,0,1}));
    }
}

