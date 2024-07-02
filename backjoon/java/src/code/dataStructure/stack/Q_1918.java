package code.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 백준 후위 표기식 (자료 구조, 스택)
// 골드 2
public class Q_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        StringBuilder output = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (char value : input) {
            if (value >= 'A' && value <= 'Z') {
                output.append(value);
            } else if (stack.isEmpty() || value == '(') {
                stack.push(value);
            } else if (stack.peek() == '(') {
                if (value == ')') {
                    stack.pop();
                } else {
                    stack.push(value);
                }

            } else if (value == '*' || value == '/') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        break;
                    }
                    if (stack.peek() != '+' && stack.peek() != '-') {
                        output.append(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(value);
            } else if (value == '+' || value == '-') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        break;
                    }
                    output.append(stack.pop());
                }
                stack.push(value);

            } else if (value == ')') {
                while (!stack.isEmpty()) {
                    char c = stack.pop();
                    if (c == '(') {
                        break;
                    } else {
                        output.append(c);
                    }

                }
            }
        }
        while(!stack.isEmpty()){
                output.append(stack.pop());
        }
        System.out.println(output);

    }

}
