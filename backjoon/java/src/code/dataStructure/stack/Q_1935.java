package code.dataStructure.stack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 백준 후위 표기식2 ( 자료 구조,스택 )
// 실버 3
public class Q_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Double[] valueArr = new Double[N];
        Queue<String> inputQue = new LinkedList<>(Arrays.asList(br.readLine().split("")));
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i <N; i++) {
            valueArr[i] = Double.parseDouble(br.readLine());
        }
        while(!inputQue.isEmpty()){
            String pollString = inputQue.poll();
            double a,b;
            switch (pollString) {
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a*b);
                    break;
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a+b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a/b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a-b);
                    break;
                default:
                    stack.push(valueArr[pollString.charAt(0)-'A']);
                    break;
            }
        }
        System.out.printf("%.2f",stack.pop());
    }
}
