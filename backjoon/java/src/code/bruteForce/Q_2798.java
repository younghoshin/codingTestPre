package code.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Q_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int blackJac = Integer.parseInt(s[1]);
        int max = 0;
        String[] input = br.readLine().split(" ");
        int[] arr = Arrays.stream(input)
                .map(Integer::parseInt)
                .mapToInt(x->x)
                .toArray();
        for (int i = 0; i <arr.length-2; i++) {
            for (int j = i+1; j <arr.length-1; j++) {
                for (int k = j+1; k <arr.length; k++) {
                    int sum = arr[i]+arr[j]+arr[k];
                    if (sum == blackJac){
                        System.out.println(sum);
                        return;
                    }
                    if (sum>max && sum<blackJac){
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
