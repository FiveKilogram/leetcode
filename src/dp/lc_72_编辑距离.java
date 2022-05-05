package dp;

import java.util.*;

/**
 *
 */

public class lc_72_编辑距离 {
    public static  int minDistance(String word1, String word2) {
    int result[][] = new int[word1.length()+1][word2.length()+1];
    for (int i = 0; i <= word1.length(); i++) {
        result[i][0] = i;
    }
    for (int i = 0; i <= word2.length(); i++) {
        result[0][i] = i;
    }

    for (int i = 1; i <= word1.length(); i++) {
        for (int j = 1; j <= word2.length(); j++) {
            if(word1.charAt(i-1)==word2.charAt(j-1)){
                result[i][j] = result[i-1][j-1];
            }else {
                result[i][j] = Math.min(Math.min(result[i-1][j],result[i][j-1]),result[i-1][j-1]) +1;
            }
            System.out.println(result[i][j]);
        }
    }
    System.out.println(result);
    return result[word1.length()][word2.length()];
}

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String word1 = scanner.next();
//        String word2 = scanner.next();
//
//        int result[][] = new int[word1.length()+1][word2.length()+1];
//        for (int i = 0; i <= word1.length(); i++) {
//            result[i][0] = i;
//        }
//        for (int i = 0; i <= word2.length(); i++) {
//            result[0][i] = i;
//        }
//
//        for (int i = 1; i <= word1.length(); i++) {
//            for (int j = 1; j <= word2.length(); j++) {
//                if(word1.charAt(i-1)==word2.charAt(j-1)){
//                    result[i][j] = result[i-1][j-1];
//                }else {
//                    result[i][j] = Math.min(Math.min(result[i-1][j],result[i][j-1]),result[i-1][j-1]) +1;
//                }
//                System.out.println(result[i][j]);
//            }
//        }
//        System.out.println(result[word1.length()][word2.length()]);
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.next();
        String word2 = scanner.next();

        String s = word1.toLowerCase();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==word2.toLowerCase().charAt(0)){
                i++;
            }
        }
    }


}
