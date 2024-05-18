package code.greedy;

import java.util.*;

public class Q_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> intStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String s = sc.nextLine();
        StringBuilder parseInt = new StringBuilder();
        int num  = 0;
        for (int i = 0; i <s.length(); i++) {
            if (s.charAt(i)=='-' || s.charAt(i)=='+'){
                num = Integer.parseInt(parseInt.toString());
                intStack.add(num);
                strStack.add(String.valueOf(s.charAt(i)));
                num = 0;
                parseInt.setLength(0);
            }else {
                parseInt.append(s.charAt(i));
            }

        }
        intStack.add(Integer.parseInt(parseInt.toString()));
        if (!strStack.contains("-")){
            int total = intStack.stream().reduce(Integer::sum).orElse(0);
            System.out.println(total);
            return;
        }
        Stack<Integer> list = new Stack<>();
        while (!strStack.isEmpty()){
            String st = strStack.pop();
            if (st.equals("+")){
                int pop = intStack.pop()+intStack.pop();
                intStack.add(pop);
            }else {
                list.add(intStack.pop());
            }
        }

        int start = intStack.pop();

        while (!list.isEmpty()){
            start = start-list.pop();
        }
        System.out.println(start);


    }
}
