package code.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 그리디 강의실 배정
//골드 5
public class Q_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new PriorityQueue<>((s1,s2)->s1-s2);
        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][2];
        for (int i = 0; i <N; i++) {
            String[] s = br.readLine().split(" ");
            input[i][0]=Integer.parseInt(s[0]);
            input[i][1]=Integer.parseInt(s[1]);
            }
        Arrays.sort(input,(s1,s2)-> {
            return s1[0] - s2[0];
        });
        queue.add(input[0][1]);
        for (int i = 1; i <input.length; i++) {
            int poll = queue.peek();
            if (input[i][0]>=poll){
                queue.poll();
            }
            queue.add(input[i][1]);

        }
        System.out.println(queue.size());
        
    }
}