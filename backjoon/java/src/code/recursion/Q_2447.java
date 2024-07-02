package code.recursion;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 별 찍기-10 (분할 정복, 재귀)
//골드 5
public class Q_2447 {

    static char[][] starArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        starArr = new char[N][N];
        StringBuilder outputStar = new StringBuilder();
        recursionStar(0,0,N,0);
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <N; j++) {
                outputStar.append(starArr[i][j]);
            }
            outputStar.append("\n");
        }
        System.out.println(outputStar);

    }

    private static void recursionStar(int i,int j, int size, int count){
        if (count == 5){
            for (int k = i; k < i+size; k++) {
                for (int l = j; l <j+size; l++) {
                    starArr[k][l] = ' ';
                }
            }
            return;
        }
        if (size == 1){
            starArr[i][j]='*';
            return;
        }

        int N = size/3;
        int blank = 0;
        for (int k = i; k < i+size; k+=N) {
            for (int l = j; l <j+size; l+=N) {
                blank++;
                recursionStar(k,l,N,blank);
            }
        }
    }
}
