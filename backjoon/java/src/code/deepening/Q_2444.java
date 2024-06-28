package code.deepening;

import java.io.*;

// 별찍기 - 7
public class Q_2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(reader.readLine());
        String star = "*";
        String space ="";
        for (int i = 0; i <testCase-1; i++) {
            space = space.concat(" ");
        }

        for (int i = 0; i < testCase-1; i++) {
//            System.out.print(space);
//            System.out.println(star);
            writer.write(space+star+"\n");
            star = star.concat("**");
            if (space.length()<=1) {
                space = "";
            }else {
                space = space.substring(1);
            }
        }
//        System.out.println(star);
        writer.write(star+"\n");
        for (int i = 1; i <testCase; i++) {
            star = star.substring(2);
            space = space.concat(" ");
//            System.out.print(space);
//            System.out.println(star);
            writer.write(space+star+"\n");
        }
        writer.flush();
        writer.close();
        reader.close();


    }
}
