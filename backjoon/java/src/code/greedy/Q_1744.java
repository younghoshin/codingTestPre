package code.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 그리디
//수 묶기 골드 4
public class Q_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> negative = new PriorityQueue<>();
        Queue<Integer> positive = new PriorityQueue<>(Comparator.reverseOrder());
        int sum=0;

        for (int i = 0; i <N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n<=0){
                negative.add(n);
            } else if (n==1) {
                sum++;
            } else{
                positive.add(n);
            }
        }
        sum = getSum(negative, sum);
        sum = getSum(positive, sum);
        System.out.println(sum);

    }


    private static int getSum(Queue<Integer> queue, int sum) {
        while(!queue.isEmpty()){
            int first = queue.poll();
            if (!queue.isEmpty()){
                int second = queue.poll();
                sum +=first*second;
            }else {
                sum +=first;
            }
        }
        return sum;
    }
}
