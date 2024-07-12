package code.dsfBfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 다리 만들기 2 (DFS,MST)
// 골드 1
public class Q_17472{
    static int N;
    static int M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] inputs;
    static boolean[][] check;
    static List<List<int[]>> island;
    static Queue<int[]> findUnionList;
    static int[] union;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        inputs = new int[N][M];
        check = new boolean[N][M];
        island = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                inputs[i][j] = Integer.parseInt(s[j]);
            }
        }
        int checkIslandNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (inputs[i][j] == 1 && !check[i][j]) {
                    List<int[]> ints = new ArrayList<>();
                    findLandDfs(checkIslandNum, ints, i, j);
                    island.add(ints);
                    checkIslandNum++;
                }
            }
        }
        union = new int[checkIslandNum];
        findUnionList = new PriorityQueue<>((s1,s2)->
                s1[2] - s2[2]);
        for(int i=0; i<union.length;i++){
            union[i] =i;
        }


        for (List<int[]> list : island) {
            for (int[] arr : list) {
                int pivot = inputs[arr[0]][arr[1]];
                findNoneArea(pivot, arr[0], arr[1]);
            }
        }

        int total = 0;
        while(!findUnionList.isEmpty()){
            total+=listToUnion(findUnionList.poll());
        }

        for (int i = 0; i <union.length; i++) {
            find(i);
        }
        int sum = Arrays.stream(union).sum();
        if (sum>checkIslandNum-1){
            total = -1;
        }else{
            total = total == 0 ? -1 : total;
        }
        System.out.println(total);
    }

    private static void findLandDfs(int checkIslandNum, List<int[]> list, int i, int j) {
        check[i][j] = true;
        inputs[i][j] = checkIslandNum;
        list.add(new int[]{i, j});

        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;
            if (x >= 0 && x < N && y >= 0 && y < M && !check[x][y]) {
                if (inputs[x][y] == 1) {
                    findLandDfs(checkIslandNum, list, x, y);
                }
            }
        }
    }

    private static void findNoneArea(int pivot, int i, int j) {

        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;
            if (x >= 0 && x < N && y >= 0 && y < M) {
                if (inputs[x][y] == 0) {
                    findRoad(pivot, 1, x, y, new int[]{dx[k], dy[k]});
                }

            }
        }

    }

    private static void findRoad(int pivot, int count, int x, int y, int[] locate) {
        int ix = x + locate[0];
        int iy = y + locate[1];
        if (ix >= 0 && ix < N && iy >= 0 && iy < M) {
            if (inputs[ix][iy] != 0) {
                if (count>1){
                    findUnionList.add(new int[]{pivot, inputs[ix][iy], count});
                }
            } else {
                check[x][y] = true;
                findRoad(pivot, count + 1, ix, iy, locate);
                check[x][y] = false;
            }
        }
    }

    private static int listToUnion(int[] info){
        int a = find(info[0]);
        int b = find(info[1]);
        if (a==b){
            return 0;
        }
        if (a>b){
            union[a] = b;
        }else{
            union[b] = a;
        }
        return info[2];

    }

    private static int find(int index){
        if (union[index]==index){
            return index;
        }
        return union[index] = find(union[index]);
    }



}
