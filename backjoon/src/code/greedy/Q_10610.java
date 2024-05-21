package code.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q_10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split("");
        Integer[] arr = new Integer[strArr.length];
        int m = 0;
        for (int i = 0; i <arr.length; i++) {
            arr[i]=Integer.parseInt(strArr[i]);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        if (arr[arr.length-1]!=0){
            System.out.println("-1");
            return;
        }else{
            int n = 0;
            for (int t:arr) {
                n=n+t;
            }
            if (n%3==0){
                String str = "";
                for (int i = 0; i <arr.length; i++) {
                    str += arr[i];
                }
                System.out.println(str);
                return;
            }
        }
        System.out.println("-1");

    }
}
