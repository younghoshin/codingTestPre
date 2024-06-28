package code.stringgs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 단어 갯수 카운트
public class Q_1152 {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int count = 0;
            for (int i = 0; i <s.length(); i++) {
                char c = s.charAt(i);
                if (i!=0 && c==' '){
                count++;
            }
                if (i==s.length()-1 && c!=' '){
                count++;
                }
            }
        System.out.println(count);


    }

}

//    BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(reader.readLine()," ");
//    int count = 0;
//        while (st.hasMoreTokens()){
//                st.nextToken();
//                count++;
//                }
//                System.out.println(count);


