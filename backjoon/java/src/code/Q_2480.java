package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_2480 {
    static int reward(int[] arr){
        int checkpoint = 0;
        if (arr[0]==arr[1]){
            if (arr[1]==arr[2]) {
                return 10000 + arr[0]*1000;
            }
            return 1000 + arr[0]*100;
        }
        if (arr[1]==arr[2]){
            checkpoint =arr[1];
        }
        else if (arr[0]==arr[2]){
            checkpoint = arr[0];
        }
        return checkpoint!=0 ? 1000 + checkpoint*100 : Arrays.stream(arr).max().orElse(0)*100;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputReader= reader.readLine().split(" ");
        int[] inventory= new int[3];
       for (int i =0; i<inputReader.length;i++){
           inventory[i] = Integer.parseInt(inputReader[i]);
       }
        System.out.println(reward(inventory));

    }
}
