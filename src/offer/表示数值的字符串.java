package offer;

public class 表示数值的字符串 {
    public boolean isNumber(String s) {
        try {
            if (s.contains("f")) return false;
            if (s.contains("F")) return false;
            if (s.contains("d")) return false;
            if (s.contains("D")) return false;
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new 表示数值的字符串().isNumber("959440.94f"));
    }
}
