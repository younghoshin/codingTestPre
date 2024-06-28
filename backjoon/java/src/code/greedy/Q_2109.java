package code.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 그리디 순회강연 우선순위 큐
// 골드 3
public class Q_2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0){
            System.out.println(0);
            return;
        }
        int[][] dpArr = new int[n][2];
        Queue<Integer> queue = new PriorityQueue<>();


        for (int i = 0; i <n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            dpArr[i][0] = p;
            dpArr[i][1] = d;
        }

        Arrays.sort(dpArr,(s1,s2)->{
            if (s1[1]==s2[1]){
                return s1[0]-s2[0];
            }
            return s1[1]-s2[1];
        });

        queue.add(dpArr[0][0]);

        for (int i = 1; i < dpArr.length; i++) {
            if (dpArr[i][1]>queue.size()){
                queue.add(dpArr[i][0]);
            } else {
                if (queue.peek()<dpArr[i][0]){
                    queue.poll();
                    queue.add(dpArr[i][0]);
                }
            }
        }

        int count = queue.stream().reduce(Integer::sum).orElse(0);
        System.out.println(count);

    }
}
