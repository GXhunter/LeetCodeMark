package offer;

public class 替换空格 {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        System.out.println(new 替换空格().replaceSpace("We are happy."));
    }
}
