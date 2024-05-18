package code.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[T][2];
        int count = 0;
        for (int i = 0; i <T; i++) {
            String[] st = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(st[0]);
            arr[i][1] = Integer.parseInt(st[1]);
        }
        Arrays.sort(arr,(s1,s2)->
                {
                    if (s1[1]==s2[1]){
                        return s1[0] - s2[0];
                    }
                    return s1[1] - s2[1];
                }
                );

            int time = 0;
            for (int i = 0; i < arr.length; i++) {
                if (time<=arr[i][0]){
                    count++;
                    time = arr[i][1];
                }
            }


        System.out.println(count);

    }
}
