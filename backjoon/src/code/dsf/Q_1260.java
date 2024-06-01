package code.dsf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 DFS 와 BFS
// 실버 2
public class Q_1260 {
    static boolean[][] nodes;
    static boolean[] nodeCheck;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N,M,V;
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        V=Integer.parseInt(st.nextToken());
        nodes = new boolean[N+1][N+1];
        nodeCheck = new boolean[N+1];
        queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());
            nodes[firstNode][secondNode] = true;
            nodes[secondNode][firstNode] = true;
        }
        dfs(V);
        queue.add(V);
        for (int i = 1; i <nodeCheck.length; i++) {
            nodeCheck[i] = false;
        }
        System.out.println();
        bfs(queue);
    }

    private static void dfs(int start){
        nodeCheck[start] = true;
        System.out.printf(start+" ");

        for (int i = 1; i <nodes[start].length; i++) {
            if (nodes[start][i] && !nodeCheck[i]){
                dfs(i);
            }
        }
    }
    private static void bfs(Queue<Integer> queue){
        if (queue.isEmpty()){
            return;
        }
        int start = queue.poll();
        nodeCheck[start] = true;
        System.out.printf(start+" ");
        for (int i = 1; i <nodes[start].length; i++) {
            if (nodes[start][i] && !nodeCheck[i]){
                queue.add(i);
                nodeCheck[i] = true;
            }
        }
        bfs(queue);
    }


}
