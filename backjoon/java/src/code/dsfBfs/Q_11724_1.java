package code.dsfBfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 dfs(깊이 우선 탐색) 연결 요소의 개수
// 실버 3
public class Q_11724_1 {
    static boolean[][] arr;
    static boolean[] checkArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        arr = new boolean[N+1][N+1];
        checkArr = new boolean[N+1];
        int count = 0;
        for (int i = 0; i <M; i++) {
            String[] st = br.readLine().split(" ");
            int v = Integer.parseInt(st[0]);
            int u = Integer.parseInt(st[1]);
            arr[v][u] =true;
            arr[u][v] =true;
        }
        for (int i = 1; i < checkArr.length; i++) {
            if (!checkArr[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);

    }
    private static void dfs(int start){
        checkArr[start] = true;
        for (int i = 1; i < arr[start].length; i++) {
            if (arr[start][i] && !checkArr[i]){
                dfs(i);
            }
        }
    }
}
