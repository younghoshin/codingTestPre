package code.dsfBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 안전 영역 dfs
// 실버 1
public class Q_2468 {
    static int[][] area;
    static boolean[][] check;
    static int[] xArr = {-1,1,0,0};
    static int[] yArr = {0,0,-1,1};
    static int maxRain;
    static int safe;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        maxRain = 0;
        for (int i = 0; i <N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j <N; j++) {
                area[i][j] = Integer.parseInt(str[j]);
                maxRain = Math.max(maxRain,area[i][j]);
            }
        }
        int maxSafe = 1;
        for (int rainPoint = 1; rainPoint < maxRain; rainPoint++) {
            safe = 0;
            check = new boolean[N][N];
            for (int i = 0; i <N; i++) {
                for (int j = 0; j <N; j++) {
                    if (area[i][j]>rainPoint && !check[i][j]){
                        safe++;
                        dfs(rainPoint,i,j);
                    }
                }
            }
            maxSafe = Math.max(safe,maxSafe);
        }
        System.out.println(maxSafe);

    }

    private static void dfs(int rainPoint, int x, int y){
        check[x][y] = true;
        for (int k = 0; k <4; k++) {
            int dx = x+xArr[k];
            int dy = y+yArr[k];
            int N = check.length;

            if (dx>=0 && dx<N && dy>=0 && dy<N && !check[dx][dy]){
                if (area[dx][dy]>rainPoint){
                    dfs(rainPoint,dx,dy);
                }
            }
        }
    }
}
