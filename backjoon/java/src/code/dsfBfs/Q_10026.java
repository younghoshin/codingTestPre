package code.dsfBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Q_10026 {
    static String[][] arr;
    static String[][] blindnessArr;
    static int N;
    static int[] matrix_x={-1,1,0,0};
    static int[] matrix_y={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N  = Integer.parseInt(br.readLine());
        arr = new String[N][N];
        blindnessArr = new String[N][N];
        for (int i = 0; i <N; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j <N; j++) {
                arr[i][j] = st[j];
            }
            for (int j = 0; j <N; j++) {
                if (!st[j].equals("B")){
                    blindnessArr[i][j] = "R";
                }else {
                    blindnessArr[i][j] = st[j];
                }
            }
        }
        int count = 0;
        int countBa = 0;
        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j <arr[i].length; j++) {
                if (!arr[i][j].equals(" ")){
                    dfs(i,j,arr[i][j],arr);
                    count++;
                }
            }
            for (int j = 0; j <blindnessArr[i].length ; j++) {
                if (!blindnessArr[i][j].equals(" ")){
                    dfs(i,j,blindnessArr[i][j],blindnessArr);
                    countBa++;
                }
            }
        }
        System.out.println(count+" "+countBa);


    }

    private static void dfs(int i,int j,String color,String[][] arr){
        arr[i][j] = " ";
        for (int k = 0; k <4; k++) {
            int dx = i+matrix_x[k];
            int dy = j+matrix_y[k];
            if (dx>=0&&dx<N&&dy>=0&&dy<N){
                if (arr[dx][dy].equals(color)){
                    dfs(dx,dy,arr[dx][dy],arr);
                }
            }
        }

    }
}
