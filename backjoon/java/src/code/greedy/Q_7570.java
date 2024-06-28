package code.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q_7570 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] times = new int[N][2];
        Queue<Integer> rooms = new PriorityQueue<>();
        for (int i = 0; i <N; i++) {
            String[] st = br.readLine().split(" ");
            times[i][0] = Integer.parseInt(st[0]);
            times[i][1] = Integer.parseInt(st[1]);
        }
        Arrays.sort(times,(s1,s2)->s1[0]-s2[0]);
        rooms.add(0);
        for (int[] time:times) {
            if (time[0]>=rooms.peek()){
                rooms.poll();
                rooms.add(time[1]);
            }else{
                rooms.add(time[1]);
            }
        }
        System.out.println(rooms.size());

    }
}
