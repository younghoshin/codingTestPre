package code.greedy;

import java.util.*;

public class Q_11399 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[T];
        int[] sumTime = new int[T];
        int total = 0;
        for (int i = 0; i <T; i++) {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i <arr.length; i++) {
            total = total+arr[i];
            sumTime[i] = total;
        }

        System.out.println(Arrays.stream(sumTime).sum());



    }

}
