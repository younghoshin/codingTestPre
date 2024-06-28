package code.dsfBfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 알파펫 dfs
// 골드 4
public class Q_1987 {
    static char[][] bored;
    static boolean[] check;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        bored = new char[R][C];
        check = new boolean[26];
        max = 0;
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            bored[i] = s.toCharArray();
        }
        check[bored[0][0]-'A'] = true;
        dfs(0,0,1);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int count){
        int[] dxArr = {1, -1, 0, 0};
        int[] dyArr = {0, 0, 1, -1};
        max = Math.max(count,max);
        int checkPoint = bored[x][y]  - 'A';
        check[checkPoint] = true;
        for (int i = 0; i <4; i++) {
            int dx = x + dxArr[i];
            int dy = y + dyArr[i];
            if (dx>=0 && dx<bored.length && dy>=0 && dy<bored[0].length){
                int checkDxDy = bored[dx][dy] - 'A';
                if (!check[checkDxDy]){
                    dfs(dx,dy,count+1);
                }
            }
        }
        check[checkPoint] = false;
    }
}
