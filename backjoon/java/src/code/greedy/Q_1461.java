package code.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> negative = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);

        st=br.readLine().split(" ");
        for (String s:st) {
            int n = Integer.parseInt(s);
            if (n>0){
                positive.add(n);
            }else {
                n=Math.abs(n);
                negative.add(n);
            }
        }
        int step = 0;
        if (negative.size()!=0){
            int max = negative.peek();
            if (positive.size()!=0){
                if (positive.peek()>max){
                    step = longs(positive,step,M);
                    step = sorts(negative,step,M);
                } else if (positive.peek()==max && positive.size()>=negative.size()) {
                    step = longs(positive,step,M);
                    step = sorts(negative,step,M);
                }else {
                    step = longs(negative,step,M);
                    step = sorts(positive,step,M);
                }
            }
            else {
                step =longs(negative,step,M);
            }

        }else {
            step = longs(positive,step,M);
        }
        System.out.println(step);

    }
    public static int sorts(Queue<Integer> list, int step, int M){
        while(!list.isEmpty()){
            step += list.poll()*2;
            for (int i = 0; i <M-1; i++) {
                list.poll();
            }
        }
        return step;
    }
    public static int longs(Queue<Integer> list, int step, int M){
        step += list.poll();
        for (int i = 0; i <M-1; i++) {
            list.poll();
        }
        while(!list.isEmpty()){
            step += list.poll()*2;
            for (int i = 0; i <M-1; i++) {
                list.poll();
            }
        }
        return step;
    }
}
