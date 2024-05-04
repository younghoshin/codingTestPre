package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] input = reader.readLine().split(" ");
        int [] intArray= new int[input.length];
        for (int i=0; i<input.length; i++){
            intArray[i] = Integer.parseInt(input[i]);
        }
        System.out.println((intArray[0]+intArray[1])%intArray[2]);
        System.out.println(((intArray[0]%intArray[2]) + (intArray[1]%intArray[2]))%intArray[2]);
        System.out.println((intArray[0]*intArray[1])%intArray[2]);
        System.out.println(((intArray[0]%intArray[2]) * (intArray[1]%intArray[2]))%intArray[2]);



    }
}
