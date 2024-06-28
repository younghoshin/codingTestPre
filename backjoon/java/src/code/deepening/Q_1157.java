package code.deepening;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String st = reader.readLine().toUpperCase();
        int maxCount = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <st.length(); i++) {
            if (map.containsKey(st.charAt(i))){
                map.put(st.charAt(i),map.get(st.charAt(i))+1);
            }else {
                map.put(st.charAt(i),1);
            }
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if (entry.getValue()==maxCount){
                st="?";
            } else if (entry.getValue()>maxCount) {
                maxCount = entry.getValue();
                st=entry.getKey().toString();
            }

        }
        System.out.println(st);
    }
}
