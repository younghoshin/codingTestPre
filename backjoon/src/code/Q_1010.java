package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 다리놓기
public class Q_1010 {

    static final int[][] bridge = new int[30][30];


    public static int bridgeCount(int west, int east){
        if (bridge[west][east]>0){
            return bridge[west][east];
        }
        if(west == east || east == 0){
            return  bridge[west][east] = 1;
        }
        return bridge[west][east] = bridgeCount(west-1,east)+bridgeCount(west-1,east-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++)
        {
            String[] temp = reader.readLine().split(" ");

            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);

            System.out.println(bridgeCount(M, N));
        }

        reader.close();





    }
}
