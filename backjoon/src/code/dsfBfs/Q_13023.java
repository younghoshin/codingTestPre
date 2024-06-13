package code.dsfBfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;


// 백준 ABCDE dfs 문제
// 골드 5
public class Q_13023 {
    static List<Integer>[] friendArr;
    static int N;
    static int output = 0;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        friendArr = new ArrayList[N];
        check = new boolean[N];
        for (int i = 0; i <N; i++) {
            friendArr[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            friendArr[first].add(second);
            friendArr[second].add(first);
        }
        for (int i = 0; i <N; i++) {
            if (output != 1){
                dfs(i,1);
            }else {
                break;
            }

        }
        System.out.println(output);

    }
    private static void dfs(int start,int dep){
        if (dep==5){
            output = 1;
            return;
        }
        check[start] = true;
        for (int i :friendArr[start]) {
            if (!check[i]){
                dfs(i,dep+1);
            }
        }
        check[start] = false;
    }
}
