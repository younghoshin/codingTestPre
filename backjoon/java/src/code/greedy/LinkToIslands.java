package code.greedy;

import java.util.Arrays;


// 프로그래머스 섬 연결하기 (그리디)
// 레밸 3
public class LinkToIslands {
    static int[] island;
    public static void main(String[] args) {
        int [][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(4,costs));
    }
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        island = new int[n];
        for (int i = 0; i <n; i++) {
            island[i] = i;
        }

        Arrays.sort(costs,(s1, s2)->
                s1[2]-s2[2]);
        for (int[] inArr : costs){
            answer+=union(inArr);
        }
        return answer;
    }


    public static int find(int index){
        if (island[index]==index){
            return index;
        }
        return island[index] = find(island[index]);

    }
    public static int union(int[] arr){
        int first = find(arr[0]);
        int second = find(arr[1]);
        if (first==second){
            return 0;
        }
        if (first>second){
            island[first] = second;
        }else{
            island[second]=first;
        }
        return arr[2];
    }

}
