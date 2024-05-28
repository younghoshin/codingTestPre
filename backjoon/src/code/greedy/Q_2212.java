package code.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// 백준 그리디 센서
// 골드 5
public class Q_2212 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int[] sensor = Arrays.stream(strArr)
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int[] split = new int[sensor.length-1];
        for (int i = 0; i <split.length; i++) {
            split[i] = sensor[i+1]-sensor[i];
        }
        Arrays.sort(split);
        for (int i = 0; i <K-1; i++) {
            split[split.length-1-i] = 0;
        }
        int sum = 0;
        for (int i: split) {
            sum+=i;
        }
        System.out.println(sum);
    }
}
