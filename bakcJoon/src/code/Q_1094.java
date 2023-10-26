package code;

import java.util.Scanner;

public class Q_1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len  = sc.nextInt();
        int i = 64;
        int price = 0;

        while (i>0){
            if (i==len){
                price++;
                break;
            } else if (i<len) {
                len=len-i;
                price++;
            }
            i=i/2;
        }
        System.out.println(price);
    }

}
