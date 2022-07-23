package 剑指offer;

public class 反转字符串中的单词3 {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s1 : split) {
            sb.append(new StringBuffer(s1).reverse());
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

}
