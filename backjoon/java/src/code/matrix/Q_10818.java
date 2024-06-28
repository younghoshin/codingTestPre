package code.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(reader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine()," ");
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i <testCase ; i++) {
            arrayList.add(
                    Integer.parseInt(stringTokenizer.nextToken())
            );
        }

//        Collections.sort(arrayList);

        int max = arrayList.stream()
                .mapToInt(m->m)
                .max()
                .orElse(0);

        int min = arrayList.stream()
                .mapToInt(m->m)
                .min()
                .orElse(0);

        System.out.println(min+" "+max);
//        System.out.println(arrayList.get(0)+" "+arrayList.get(arrayList.size()-1));



    }
}
