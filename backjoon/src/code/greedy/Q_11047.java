package code.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Q_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int T = Integer.parseInt(s[0]);
        int total = Integer.parseInt(s[1]);
        Integer[] coinArr = new Integer[T];
        int count = 0;
        for (int i = 0; i <T; i++) {
            coinArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coinArr,Collections.reverseOrder());
        for (int n: coinArr) {
            if (total/n>0){
                count = count + total/n;
                total = total%n;
            }
            if (total == 0){
                break;
            }
        }
        System.out.println(count);
    }
}
