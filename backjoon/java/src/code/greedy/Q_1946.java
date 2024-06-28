package code.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 그리디 신입사원 실버 1
public class Q_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i <T; i++) {
            int N =Integer.parseInt(br.readLine());
            System.out.println(getInt(N,br));
        }

    }
    public static int getInt(int N,BufferedReader br) throws IOException{
        int[][] arr = new int[N][2];
        int count = 1;

        for (int i = 0; i <N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(s1,s2)->s1[0]-s2[0]);
        int min = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (min>arr[i][1]){
                count++;
                min =arr[i][1];
            }
        }
        return count;
    }
}
