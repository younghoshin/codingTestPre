package code.bruteForce;

import java.util.Scanner;

public class Q_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int num = 0;
        int count = 0;

        while(count!=T){
            num++;
            if(666<=num){
                String s = Integer.toString(num);
                    if (s.contains("666")){
                        count++;
                    }

            }
        }
        System.out.println(num);

    }
}
