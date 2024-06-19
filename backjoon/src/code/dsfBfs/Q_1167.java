package code.dsfBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q_1167 {
    static List<List<Node>> nodes;
    static List<Integer> leafNodes = new ArrayList<>();
    static boolean[] check;
    static int max;
    static int maxNode;
    public static void main(String[] args) throws Exception{
        //인풋 받기
        input();
        // dfs 탐색하기
        check = new boolean[nodes.size()];
        dfs(1,0);
        check = new boolean[nodes.size()];
        dfs(maxNode,0);

        System.out.println(max);
    }



    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nodes = new ArrayList<>();
        for (int i = 0; i <N+1; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i <N; i++) {
            String[] str = br.readLine().split(" ");
            int nodeNum = Integer.parseInt(str[0]);
            for (int j = 1; j < str.length-1; j+=2) {
                int num  = Integer.parseInt(str[j]);
                int value  = Integer.parseInt(str[j+1]);
                nodes.get(nodeNum).add(new Node(num,value));
            }
        }
    }
    private static void dfs(int start,int count){
        check[start] = true;
        if (max<count){
            max = count;
            maxNode = start;
        }
        for (Node nodeList:nodes.get(start)) {
            if (!check[nodeList.getNum()]){
                dfs(nodeList.getNum(), count+nodeList.getValue());
            }
        }
    }



    static class Node{
        private final int num;
        private final int value;

        public Node(int num, int value) {
            this.num = num;
            this.value = value;
        }

        public int getNum() {
            return num;
        }

        public int getValue() {
            return value;
        }
    }
}
