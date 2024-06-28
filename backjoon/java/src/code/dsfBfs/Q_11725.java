package code.dsfBfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백준 트리의 부모 찾기 dfs 문제
// 실버 3
public class Q_11725 {
    static List<Integer>[] node;
    static boolean[] check;
    static int[] rootList;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        node = new ArrayList[N+1];
        check = new boolean[N+1];
        rootList = new int[N+1];
        for (int i = 0; i <N+1; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 1; i <N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            node[first].add(second);
            node[second].add(first);
        }
            dfs(1);
        for (int i = 2; i < rootList.length; i++) {
            System.out.println(rootList[i]);
        }
    }

    private static int dfs(int start){
        check[start]= true;
        for (int i : node[start]) {
            if (!check[i]){
                int child = dfs(i);
                rootList[child] = start;
            }
        }
        return start;
    }
}
