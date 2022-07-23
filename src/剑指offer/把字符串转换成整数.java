package 剑指offer;



public class 把字符串转换成整数 {
    java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^\\s*([+\\-]?\\d+).*");

    public int strToInt(String str) {
        java.util.regex.Matcher matcher = pattern.matcher(str);
        String res = null;
        if (matcher.find()) {
            res = matcher.group(1);
        }
        if (res == null) {
            return 0;
        }
        try {

            return Integer.parseInt(res);
        } catch (NumberFormatException e) {
            return res.contains("-") ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        System.out.println(new 把字符串转换成整数().strToInt("-91283472332"));
    }
}
