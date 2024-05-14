package code.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Q_2839 {

    private static int bags(int n, int m){
        if (n<3){
            return -1;
        }
        if (n%5==0){
            return n/5+m;
        }
        else if (n%3==0 && n<=12){
            return n/3+m;
        }
        else {
            return bags(n-5,m+1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        System.out.println(bags(T,0));
    }

}
