package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 막대기
public class Q_1094 {
    static int lanX = 64;
    static int count = 0;
    public static int countStick(int lan){
        // 길이가 1이라면 더 이상 나누어 질 수 없기 때문에 카운트에 1을 더하고 리턴함
        if (lan == 1){
            return count + 1;
        }
        // 현재 만들 막대기보다 길기 떄문에 나눈기 2한 다음 다시 재귀 호출함
        else if (lan < lanX){
            lanX = lanX/2;
            return countStick(lan);
        }
        // 현재 만들 막대기 보다 남은 막대기의 길이가 더 작기 때문에 남은 막대기의 길이를 뺀다음 만들 나무가지에 붙혀 카운드를 더한 다음
        // 다시 재귀 호출함
        else if (lan > lanX){
            count = count+1;
            lan = lan - lanX;
            return countStick(lan);
        }
        //길이가 그대로 붙이면 되기 떄문에 현재 붙힐수있는 나무길이(count)에 더하여 리턴함
        else {
            return count + 1;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lan = Integer.parseInt(reader.readLine());

        System.out.println(countStick(lan));


    }
}
