package dp;

import java.util.Scanner;

/**
 * N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。
 * 通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
 * 例子：
 * 123 124 125 123 121 是一个合唱队形
 * 123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
 * 123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
 *
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 * 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
 *
 * 数据范围： 1 \le n \le 3000 \1≤n≤3000
 *
 * 输入描述：
 * 用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
 *
 * 输出描述：
 * 最少需要几位同学出列
 * 输入：
 * 8
 * 186 186 150 200 160 130 197 200
 * 复制
 * 输出：
 * 4
 * 复制
 * 说明：
 * 由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为186 200 160 130或150 200 160 130
 */

public class 合唱队 {
    public static void main(String[] args) {
        Scanner scananer = new Scanner(System.in);

        int num = scananer.nextInt();
        int i = 0 ;
        int people[] = new int[num];
        int people2[] = new int[num];
        while (i<num){
            people[i] = scananer.nextInt();
            i++;
        }
        for (int j = people.length; j > 0 ; j--) {
            people2[people.length-j] = people[j-1];
        }

        int result1[] = new int[num];
        int result2[] = new int[num];
        int result3[] = new int[num];

        int result11[] = new int[num];
        int result22[] = new int[num];

        result1[0] = 1;
        result2[0] = 1;
        result11[0] = 1;
        result22[0] = 1;
        int max = 1;
        for (int j = 1; j < people.length; j++) {
            result1[j] = 1;
            for (int k = 0; k < j; k++) {
                if(people[j]>people[k]){
                    result1[j] = Math.max(result1[j],result1[k]+1);
                }
            }
            max = Math.max(max,result1[j]);
            result11[j] = max;
        }
        result2[0] = 1;
        int max2 = 1;
        for (int j = 1; j < people.length; j++) {
            result2[j] = 1;
            for (int k = 0; k < j; k++) {
                if(people2[j]>people2[k]){
                    result2[j] = Math.max(result2[j],result2[k]+1);
                }
            }
            max2 = Math.max(max2,result2[j]);
            result22[j] = max2;
        }
        int resultnum = 0;
        for (int j = 0; j < people.length; j++) {
            result3[j] = 0;
            if(result11[j]!=1&&result22[people.length-1-j]!=1){
                result3[j] = result11[j] +result22[people.length-1-j] -1;
                if(result3[j]>resultnum){
                    resultnum= result3[j];
                }
            }
        }
        System.out.println(people.length-resultnum);

//        max = 0;
//        for (int j = 0; j < people.length; j++) {
//            if(people2[j]>max){
//                result2[j+1] = result2[j] + 1;
//                max = people2[j];
//            }else {
//                result2[j+1] = result2[j];
//            }
//        }
        System.out.println();

    }
}
