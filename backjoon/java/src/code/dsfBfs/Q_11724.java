package code.dsfBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 백준 dfs(유니온 파인드 사용) 연결 요소의 개수
// 실버 3
public class Q_11724 {
    static int[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);
        nodes = new int[N+1];
        for (int i = 1; i <N+1; i++) {
            nodes[i]=i;
        }
        for (int i = 1; i <M+1; i++) {
            String[] sts = br.readLine().split(" ");
            int first = Integer.parseInt(sts[0]);
            int second = Integer.parseInt(sts[1]);
            if (findRoot(first)!=findRoot(second)){
                union(first,second);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nodes.length ; i++) {
            set.add(findRoot(nodes[i]));
        }
        System.out.println(set.size());
    }

    private static int findRoot(int i){
        if (nodes[i]==i){
            return i;
        }
        return nodes[i]=findRoot(nodes[i]);
    }

    private static void union(int first,int second){
        int fn = findRoot(first);
        int sn = findRoot(second);
        int root = Math.min(fn,sn);
        nodes[fn] =root;
        nodes[sn] =root;
    }

}
