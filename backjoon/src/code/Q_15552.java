package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q_15552 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(reader.readLine());

        for (int i = 0; i<testCase;i++){
            StringTokenizer st =new StringTokenizer(reader.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            writer.write((a+b)+"\n");
        }
        writer.flush();
        writer.close();

    }
}
