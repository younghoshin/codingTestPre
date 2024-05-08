package code.stringgs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 그대로 출력
public class Q_11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        while(i<100){
            i++;
            String s = reader.readLine();
            if (s!=null){
                System.out.println(s);
            }
        }




    }
}
