package code.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//백준 그리디 A와B
//골드 5
public class Q_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        List<String> stringList = new ArrayList<>(List.of(br.readLine().split("")));
        while(S.length()<stringList.size()){
            if (stringList.get(stringList.size()-1).equals("A")){
                stringList.remove(stringList.size()-1);
            }else{
                stringList.remove(stringList.size()-1);
                swap(stringList);
            }
        }
        String vert = "";
        for (String s: stringList) {
            vert+=s;
        }
        if (S.equals(vert)){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
    private static void swap(List<String> list){
        int end = list.size()-1;
        for (int i = 0; i <list.size()/2; i++) {
            String tmp = list.get(i);
            list.set(i,list.get(end));
            list.set(end,tmp);
            end--;
        }
    }

}
