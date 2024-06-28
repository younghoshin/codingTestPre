package code.dsfBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 백준 치즈 DFS(BFS)
// 골드 3
public class Q_2638 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] cheeses;
    static boolean[][] check;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        int count = 0;
        insertArr();
        initCheeses(0,0);
        while(countCheck()){
            setCheeses();
            resetCheeses();
            count++;
        }
        System.out.println(count);
    }


    private static void insertArr() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheeses = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer sts = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheeses[i][j] = Integer.parseInt(sts.nextToken());
            }
        }

    }

    //초기 치즈를 확인하여 녹는 치즈인지 확인
    private static void initCheeses(int C,int R){
        cheeses[C][R] = 3;
        for (int i = 0; i < 4; i++) {
            int X = C+dx[i];
            int Y = R+dy[i];
            if (X>=0 && X<N && Y>=0 && Y<M){
                if (cheeses[X][Y] == 0){
                    initCheeses(X,Y);
                }
            }
        }
    }

    // 녹는 치즈인지 확인 한후 다음 치즈로 변환할 치즈확인
    private static void setCheeses(){
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <M; j++) {
                if (cheeses[i][j] == 1 && checkCheeses(i,j)>=2){
                    cheeses[i][j] = 5;
                }
            }
        }
    }

    // 변환확인한 치즈를 녹은 상태로 변환
    private static void resetCheeses(){
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <M; j++) {
                if (cheeses[i][j] == 5){
                    cheeses[i][j] = 3;
                }
            }
        }
        check = new boolean[N][M];
        reInitCheeses(0,0);
    }
    private static void reInitCheeses(int C, int R){
        check[C][R] = true;
        // 체크 배열이 필요함
        if (cheeses[C][R]==0){
            cheeses[C][R] = 3;
        }
        for (int i = 0; i < 4; i++) {
            int X = C+dx[i];
            int Y = R+dy[i];
            if (X>=0 && X<N && Y>=0 && Y<M){
                if ( cheeses[X][Y] != 1 && !check[X][Y]){
                    reInitCheeses(X,Y);
                }
            }
        }

    }

    // 녹는 치즈인지 확인
    private static int checkCheeses(int C, int R){
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int X = C+dx[i];
            int Y = R+dy[i];
            if (X>=0 && X<N && Y>=0 && Y<M){
                if (cheeses[X][Y] == 3){
                    count++;
                }
            }
        }
        return count;
    }

    // 남아있는 치즈가 있는지 확인함
    private static boolean countCheck(){
        for (int[] arr: cheeses) {
            for (int i :arr) {
                if (i==1){
                    return true;
                }
            }
        }
        return false;
    }
}
