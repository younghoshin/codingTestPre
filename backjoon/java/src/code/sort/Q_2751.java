package code.sort;

import java.io.*;
import java.util.Arrays;
public class Q_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        for (int i = 0; i <T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(arr);
        for (int n: arr) {
            bw.write(n+"\n");
        }
        bw.flush();
        bw.close();

    }
}
