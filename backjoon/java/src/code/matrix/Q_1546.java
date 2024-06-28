package code.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1차원 배열 평균 문제
public class Q_1546 {
    public static void main(String[] args) throws IOException {
        // 점수중 최대 값 = M 임
        // 모든 점수를 점수/M*100 으로 고친다
        // --> 최고점이 70, 수학이 50이면 50/70*100
        // 예제 -> 3 다음줄에 40 80 60
        // 최고점은 80
        // 40/80*100, 80/80*100, 60/80*100
        // 50 , 100, 3/4*100 = 75
        // 따라서 평균은 50+100+75/3 = 75

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer st = new StringTokenizer(reader.readLine()," ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        double max = arr[arr.length-1];
        double avg = 0;

        for (int i = 0; i < arr.length; i++) {
            avg += arr[i]/max*100;
        }

        System.out.println(avg/ arr.length);


    }
}
