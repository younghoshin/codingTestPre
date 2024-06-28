package code.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Q_2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] sArr = br.readLine().split(" ");
        int[] arr = Arrays.stream(sArr).mapToInt(x->Integer.parseInt(x)).toArray();
        Arrays.sort(arr);
        int point = arr[0];
        for (int i = 1; i <arr.length; i++) {
            if (point+1<arr[i]){
                System.out.println(point+1);
                return;
            }
            point+=arr[i];
        }


        System.out.println(point+1);

    }
}
