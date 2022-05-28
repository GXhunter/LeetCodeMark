package utils;

import java.io.Serializable;

public class PrintUtils {
    public static void print(char[][] source) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                System.out.printf("%s ",source[i][j]);
            }
            System.out.println();
        }
    }
}
