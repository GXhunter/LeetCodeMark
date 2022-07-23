package 数组;

public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; ; i++) {
            char c;
            for (String str : strs) {
                if (strs[0].length() <= i || str.length() <= i||strs[0].charAt(i) != str.charAt(i)) {
                    return str.substring(0, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new 最长公共前缀().longestCommonPrefix(new String[]{
                "dog",
                "racecar",
                "car"
        }));
    }
}
