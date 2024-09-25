package code.dsfBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 백준 로봇 청소기
// 골드 5 BFS
public class Q_14503 {
    private static int N,M;
    private static int[][] room;
    private static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i <N; i++) {
            room[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(BFS(start));
    }

    private static int BFS(int[] start){
        int cnt = 1;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<Point> queue = new LinkedList<>();
        room[start[0]][start[1]] = 2;
        queue.offer(new Point(start[0],start[1],start[2]));
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            int position = point.position;
            boolean check = false;
            for (int i = 3; i >=0; i--) {
                int renewPos = (position+i)%4;
                int nx = x+dx[renewPos];
                int ny = y+dy[renewPos];
                if (room[nx][ny] == 0){
                    queue.offer(new Point(nx,ny,renewPos));
                    room[nx][ny] = 2;
                    cnt++;
                    check = true;
                    break;
                }
            }
            if (!check){
                x = x - dx[position];
                y = y - dy[position];
                if (room[x][y] != 1){
                    queue.offer(new Point(x,y,position));
                }else{
                    return cnt;
                }
            }
        }
        return cnt;
    }
    public static class Point{
        int x;
        int y;
        int position;
        public Point(int x, int y, int position){
            this.x=x;
            this.y=y;
            this.position = position;
        }
    }




}

