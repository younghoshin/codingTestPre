package code.dsfBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 백준 토마토
// 골드 5 BFS
public class Q_7576 {
    private static int N,M;
    private static int[][] box;
    public static void main(String[] args) throws IOException {
        boolean isTomato = false;
        Queue<Node> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        for (int i = 0; i <N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j <M; j++) {
                int tomato = Integer.parseInt(inputs[j]);
                isTomato = isTomato ? isTomato : tomato == 0;
                box[i][j] = tomato;
                if (tomato == 1){
                    queue.offer(new Node(i,j,0));
                }
            }
        }
        System.out.println(isTomato ? BFS(queue) : 0);
    }

    private static int BFS(Queue<Node> queue){
        int date = 0;
        int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            Node node = queue.poll();
            date = node.dateTime;
            int n = node.x;
            int m = node.y;
            for (int[] arr : pos){
                int in = n+arr[0];
                int im = m+arr[1];
                if (in>=0 && im>=0 && in<N && im<M &&box[in][im]==0){
                    box[in][im]=1;
                    queue.offer(new Node(in,im, node.dateTime+1));
                }
            }
        }

        return boxCheck() ? -1 : date;
    }
    private static boolean boxCheck(){
        for (int[] arr : box){
            if (Arrays.stream(arr).anyMatch(x->x==0)){
                return true;
            }
        }
        return false;
    }
    public static class Node{
        private int x;
        private int y;
        private int dateTime;
        public Node(int x,int y, int dateTime){
            this.x=x;
            this.y=y;
            this.dateTime = dateTime;
        }
    }
}

