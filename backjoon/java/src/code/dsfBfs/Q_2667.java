package code.dsfBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_2667 {
    static int[][] matrix;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for (int i = 0; i <N; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j <st.length; j++) {
                matrix[i][j] = Integer.parseInt(st[j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <N; j++) {
                if (matrix[i][j] == 1){
                    count = 0;
                    dsf(i,j,N);
                    if (count > 0){
                        list.add(count);
                    }
                }


            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        list.forEach(System.out::println);
    }

    private static void dsf(int x,int y,int N){
        count++;
        matrix[x][y] = 0;
        for (int i = 0; i <4; i++) {
            int ix = x+dx[i];
            int iy = y+dy[i];
            if (ix>=0&&iy>=0 && ix<N && iy<N){
                if (matrix[ix][iy] == 1) {
                    dsf(ix, iy, N);
                }
            }
        }
    }

}
