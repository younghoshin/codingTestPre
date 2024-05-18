package code.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q_10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Strut> strutList = new ArrayList<>();
        for (int i = 0; i <T; i++) {
            String[] s = br.readLine().split(" ");
            strutList.add(new Strut(Integer.parseInt(s[0]),s[1]));
        }
        strutList.stream().sorted((s1,s2)->
                s1.getN() - s2.getN())
                .forEach(x-> System.out.println(x.getString()));
    }
}
class Strut{
    private final int n;
    private final String name;

    public Strut(int n, String name) {
        this.n = n;
        this.name = name;
    }

    public int getN() {
        return n;
    }
    public String getString(){
        return n+" "+name;
    }
}