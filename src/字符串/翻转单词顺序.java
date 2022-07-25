package 字符串;

public class 翻转单词顺序 {
    public String reverseWords(String s) {
        String[] split = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new 翻转单词顺序().reverseWords("a good   example"));
    }
}
