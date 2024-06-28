package code.greedy;

import java.util.Scanner;

//백준 그리디 알고리즘 주요소 문제 실버 3
public class Q_13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[][] arr = new long[T-1][2];

        for (int i = 0; i <T-1; i++) {
            arr[i][1] = sc.nextLong();
        }
        for (int i = 0; i <T-1; i++) {
            arr[i][0] = sc.nextLong();
        }
        int point = 0;
        long len = arr[0][1];
        long price = 0;
        for (int i = 1; i < T-1; i++) {
                if (arr[point][0] > arr[i][0]) {
                    price = price + len * arr[point][0];
                    point = i;
                    len = arr[point][1];

                } else {
                    len = len + arr[i][1];
                }

        }
        price = price + len*arr[point][0];
        System.out.println(price);
    }
}
