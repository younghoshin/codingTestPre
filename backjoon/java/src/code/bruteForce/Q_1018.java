package code.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        String [][] strArr = new String[N][M];
        int min = 1000;
        for (int i = 0; i <N; i++) {
            strArr[i] = br.readLine().split("");
        }

        for (int m = 0; m <=strArr.length-8; m++) {
            for (int i = 0; i <=strArr[m].length-8; i++) {
                int reversCard =  countReversCards(strArr, m, i);
                min = Math.min(min,reversCard);
            }
        }
        System.out.println(min);

    }

    private static int countReversCards(String[][] strArr, int m, int i) {

        int countW = 0;
        int countB = 0;

        for (int j = m; j < m+8; j++) {
            for (int k = i; k < i+8; k++) {
                if ((j+k)%2==0){
                    if (!strArr[j][k].equals("W")){
                        countW++;
                    }
                    else if (!strArr[j][k].equals("B")){
                        countB++;
                    }
                }
                else {
                    if (!strArr[j][k].equals("B")){
                        countW++;
                    }
                    else if (!strArr[j][k].equals("W")){
                        countB++;
                    }
                }
            }
        }
        return Math.min(countB,countW);
    }

}
