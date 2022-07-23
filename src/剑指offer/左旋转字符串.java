package 剑指offer;

public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        n = n % s.length();
        return s.substring(n)+s.substring(0,n);
    }

    public static void main(String[] args) {
        System.out.println(new 左旋转字符串().reverseLeftWords("abcdefg", 2));
    }
}
