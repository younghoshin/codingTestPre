package code.matrix;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 바구니 뒤집기 문제
public class Q_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine()," ");

        int[] arr = new int[Integer.parseInt(st.nextToken())];
        int testCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i <arr.length; i++) {
            arr[i]=i+1;
        }

        for (int i = 0; i<testCount; i++){
            st =  new StringTokenizer(reader.readLine()," ");
            int first = Integer.parseInt(st.nextToken())-1;
            int second = Integer.parseInt(st.nextToken())-1;

            while (first<second){
                int n = arr[first];
                arr[first] = arr[second];
                arr[second] = n;
                first++;
                second--;
            }

        }
        String s = Arrays.toString(arr);
        s = s.substring(1,s.length()-1).replace(",","");
        System.out.println(s);
    }
}
