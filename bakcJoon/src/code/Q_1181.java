package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_1181 {

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Set<String> wordSet = new HashSet<>();

    for (int i = 0; i < N; i++) {
        String word = br.readLine();
        wordSet.add(word); // 중복된 단어는 Set을 통해 제거
    }

    List<String> wordList = new ArrayList<>(wordSet);

    // 조건에 따라 정렬
    wordList.sort((s1, s2) -> {
        if (s1.length() == s2.length()) {
            return s1.compareTo(s2); // 길이가 같으면 사전 순으로
        }
        return s1.length() - s2.length(); // 길이가 짧은 것부터
    });

    // 정렬된 단어들 출력
    for (String word : wordList) {
        System.out.println(word);
    }
}
// 스트림사용
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int count = Integer.parseInt(br.readLine());
//        String[] list = new String[count];
//
//        for (int i =0; i<count; i++){
//            list[i]=br.readLine();
//        }
//        Arrays.sort(list);
//        List<String> stringList = new ArrayList<>();
//        for (String s: list) {
//            if (!stringList.contains(s)){
//                stringList.add(s);
//            }
//        }
//        stringList.stream()
//                .sorted(Comparator.comparing(String::length))
//                .forEach(System.out::println);
//
//    }
}