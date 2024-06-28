package code.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 그리디, 분리 집합(union find 알고리즘)
// 골드 2
public class Q_10775 {
    static int[] planes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        planes = new int[G+1];
        for (int i = 1; i <G+1; i++) {
            planes[i]=i;
        }
        int count =0;
        for (int i = 0; i <P; i++) {
            int n =Integer.parseInt(br.readLine());
            int findPoint = find(n);
            if (findPoint==0){
                break;
            }
            count++;
            union(findPoint,findPoint-1);

        }
        System.out.println(count);

    }
    private static int find(int i){
        if (planes[i]==i){
            return i;
        }
        planes[i] = find(planes[i]);
        return planes[i];
    }
    private static void union(int first,int second){
        int x = find(first);
        int y = find(second);
        if (x>y){
            planes[x]=y;
        }
    }


}
