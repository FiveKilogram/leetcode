package HUAWEI;

import java.util.*;


/**
 * 2
 * 00001001 00ABCD00
 * 3
 * FFFFFAAB FFFFFAAB 00ABCD00
 *
 *
 * [00001001 00ABCD00 FFFFFAAB]
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int i = 0;
        String str[] = new String[num];
        while (i<num){
            str[i] = scanner.next();
            i++;
        }

        int num2 = scanner.nextInt();
        int j = 0;
        String str2[] = new String[num2];
        while (j<num2){
            str2[j] = scanner.next();
            j++;
        }


        long[] int1 = new long[num];
        long int2[] = new long[num2];

        HashSet<Long> hashSet = new HashSet();

        for (int k = 0; k < num; k++) {
            int1[k] = Long.parseLong(str[k],16);
            hashSet.add(int1[k]);
        }
        for (int k = 0; k < num2; k++) {
            int2[k] = Long.parseLong(str2[k],16);
            hashSet.add(int2[k]);
        }

        long[] ditinct = ditinct(int1, int2);


        String re[] = new String[ditinct.length];
        for (int k = 0; k < ditinct.length; k++) {
            re[k] = Long.toHexString(ditinct[k]);
        }
        System.out.print("[");
        for (int k = 0; k < re.length; k++) {
            re[k].toUpperCase();
            if(re[k].length()<8){
                int kkk = re[k].length();
                for (int l = 0; l < 8-kkk; l++) {
                    re[k] = "0"+re[k];
                }
            }
            if(k!=0){
                System.out.print(" "+re[k].toUpperCase());
            }else {
                System.out.print(re[k].toUpperCase());
            }
        }
        System.out.println("]");
    }

    private static long[] ditinct(long[] arr1, long[] arr2){
        Map<Long,Long> map = new TreeMap<>();
        for (long i:arr1) {
            map.putIfAbsent(i,i);
        }
        for (long i:arr2) {
            map.putIfAbsent(i,i);
        }
        Collection<Long> values = map.values();
        Iterator<Long> it = values.iterator();
        long[] arr = new long[values.size()];
        int i = 0;
        while (it.hasNext()){
            arr[i++] = it.next();
        }
        return arr;
     }

}