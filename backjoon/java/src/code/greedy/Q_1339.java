package code.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 그리디 단어 수학
//골드 4
public class Q_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] words = new int[26];
        for (int i = 0; i < 10; i++) {
            stack.add(i);
        }

        String[] strArr = new String[T];
        int num =0;

        for (int i = 0; i <T; i++) {
            strArr[i] = br.readLine();
        }

        for (String s : strArr) {
            for (int j = 0; j < s.length(); j++) {
                int word = s.charAt(j) - 'A';
                int digit = s.length() - 1 - j;
                words[word] = words[word] + (int) Math.pow(10, digit);
            }
        }
        Arrays.sort(words);
        for (int i = words.length-1; i >=0 ; i--) {
            if (words[i]==0){
                break;
            }
            num = num + words[i] * stack.pop();

        }
        System.out.println(num);



    }

//    static class Words{
//        private char word;
//        private int digit;
//
//        public Words(char word, int digit){
//            this.word = word;
//            this.digit = digit;
//        }
//
//        public char getWord() {
//            return word;
//        }
//
//        public int getDigit() {
//            return digit;
//        }
//
//        public void setWord(char word) {
//            this.word = word;
//        }
//
//        public void setDigit(int digit) {
//            this.digit = digit;
//        }
//    }


}

