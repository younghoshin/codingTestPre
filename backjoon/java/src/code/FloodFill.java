package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FloodFill {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static List<int[]> flood;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        flood = new ArrayList<>();
        int x = 0;
        int y = 0;
        while(true){
            String[] st = br.readLine().split(" ");
            if (st.length==2) {
                x = Integer.parseInt(st[0]);
                y = Integer.parseInt(st[1]);
                break;
            }
            int[] arr = new int[st.length];
            for (int i = 0; i <arr.length; i++) {
                arr[i]= Integer.parseInt(st[i]);
            }
            flood.add(arr);
        }

        dfs(y,x);
        for (int[] arr:flood){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <arr.length; i++) {
                if (i==arr.length-1){
                    sb.append(arr[i]);
                }else{
                    sb.append(arr[i]).append(" ");
                }
            }
            System.out.println(sb);
        }


    }
    private static void dfs(int y,int x){
        if (flood.get(y)[x]==0){
            flood.get(y)[x] = 1;
        }

        for (int i = 0; i <4; i++) {
            int Y = dy[i]+y;
            int X = dx[i]+x;
            if(Y>=0 && Y<flood.size()&& X>=0 && X<flood.get(0).length) {
                if (flood.get(Y)[X]==0){
                    dfs(Y,X);
                }
            }
        }
    }
}
