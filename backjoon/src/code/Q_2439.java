package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(reader.readLine());
        String star = "";
        for (int i = 0; i<testCase; i++){
            star = star.concat(" ");
        }

        for (int i = testCase; i>0; i--){
                star =  star.concat("*");
                star = star.substring(1);
        }
    }
}
