package code.dsfBfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//맥주 마시면서 걸어가기
// BFS 골드5
public class Q_9205 {
    private static int[][] point;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            point = new int[n+1][2];
            for (int j = 0; j <n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                point[j][0] = Integer.parseInt(st.nextToken());
                point[j][1] = Integer.parseInt(st.nextToken());
            }
            int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            point[n] = end;
            System.out.println(BFS(start,end) ? "happy" : "sad");

        }
    }
    private static boolean BFS (int[] start, int[] end){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[point.length];
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];
            for (int i = 0; i < point.length; i++){
                int[] pot = point[i];
                int distance = Math.abs(x-pot[0]) + Math.abs(y-pot[1]);
                if (distance<=1000){
                    if (pot == end){
                        return true;
                    }
                    if (!visited[i]){
                        queue.offer(pot);
                        visited[i] = true;
                    }

                }
            }
        }
        return false;
    }
}
