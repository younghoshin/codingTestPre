package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2884 {
    static int [] setTimes(int time){
        int hour,minute;
        if (time-45<0){
            time = (time+24*60) - 45;
        }
        else {
            time = time-45;
        }

        hour = time/60;
        minute = time%60;

        return new int[]{hour,minute};
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] readerStr = reader.readLine().split(" ");
        int hour = Integer.parseInt(readerStr[0]);
        int minute = Integer.parseInt(readerStr[1]);
        int sumMinute = hour*60+minute;
        int[] totalTime = setTimes(sumMinute);

        System.out.println(totalTime[0]+" "+totalTime[1]);

    }
}
