package code.dsfBfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

    public class Q_1967 {
    static List<List<Node>> nodes;
    static boolean[] check;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nodes = new ArrayList<>();
        for (int i = 0; i <n+1; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 1; i <n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            nodes.get(root).add(new Node(nextNode,value));
            nodes.get(nextNode).add(new Node(root,value));
        }
        List<Integer> leafNodes = new ArrayList<>();
        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(i).size()==1){
                leafNodes.add(i);
            }
        }
        for (int leaf: leafNodes) {
            check = new boolean[n+1];
            dfs(leaf,0);
        }
        System.out.println(max);
    }

    private static void dfs(int start,int sum) {
        check[start] = true;
        max = Math.max(sum, max);
        List<Node> nodes1= nodes.get(start);
        for (Node N: nodes1) {
            if (!check[N.getNum()]){
                dfs(N.getNum(),sum+N.getLen());
            }
        }
    }
    static class Node{
        private final int num;
        private final int len;

        public Node(int num, int len) {
            this.num = num;
            this.len = len;
        }

        public int getNum() {
            return num;
        }

        public int getLen() {
            return len;
        }
    }


}
