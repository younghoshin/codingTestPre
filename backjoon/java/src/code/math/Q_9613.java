package code.math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 GCD(최대 공약수, 유클리드 호제법) 합 수학1
// 실버 2
public class Q_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <N; i++) {
            String[] input = br.readLine().split(" ");
            long sum = 0;
            for (int j = 1; j < input.length-1; j++) {
                int first = Integer.parseInt(input[j]);
                for (int k = j+1; k < input.length; k++) {
                    int second = Integer.parseInt(input[k]);
                    int min = Math.min(first,second);
                    int max = Math.max(first,second);
                    sum += gcd(max,min);
                }
            }
            System.out.println(sum);
        }
    }
    private static int gcd(int first, int second){
        if (first%second == 0){
            return second;
        }
        return gcd(second, first%second);
    }

}
