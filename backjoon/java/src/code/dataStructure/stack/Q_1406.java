package code.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;


// 백준 에디터 자료구조(stack)
// 실버 2
public class Q_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> rightStack = new Stack<>();
        Deque<String> leftDeq = new ArrayDeque<>(Arrays.asList(br.readLine().split("")));
        int N  = Integer.parseInt(br.readLine());
        for (int i = 0; i <N; i++) {
            String[] inputStr = br.readLine().split(" ");
            switch (inputStr[0]) {
                case "L":
                    if (!leftDeq.isEmpty()) {
                        rightStack.push(leftDeq.pollLast());
                    }
                    break;
                case "D":
                    if (!rightStack.isEmpty()) {
                        leftDeq.add(rightStack.pop());
                    }
                    break;
                case "B":
                    if (!leftDeq.isEmpty()) {
                        leftDeq.pollLast();
                    }
                    break;
                default:
                    leftDeq.add(inputStr[1]);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!leftDeq.isEmpty()){
            sb.append(leftDeq.pollFirst());
        }
        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }
}

