package code.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i <T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] location = Arrays.stream(arr).distinct().sorted().toArray();

        for (int i = 0; i <T; i++) {
            int low = 0;
            int high = location.length;
            while (low <= high) {
                int mid = low + (high-low) / 2;
                if (location[mid] == arr[i]) {
                    wr.write(mid+" ");
                    break;
                }
                else if (location[mid]> arr[i]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }

            }
        }
        br.close();
        wr.flush();
        wr.close();
    }
}
