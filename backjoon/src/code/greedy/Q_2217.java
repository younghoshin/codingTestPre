package code.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//백준 2217번 로프 그리디 알고리즘 실버 4
public class Q_2217 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int[] arr = new int[sc.nextInt()];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int max = 0;
        for (int i = 0; i <arr.length; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = arr.length-1; i>=0; i--) {
            max = Math.max(max,arr[i]*(arr.length-i));
        }
        System.out.println(max);

    }
}
