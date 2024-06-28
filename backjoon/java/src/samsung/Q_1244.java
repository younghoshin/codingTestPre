package samsung;

import java.util.*;

public class Q_1244 {
	static String[] arr;
	static int max;
	private static void dsf(int n) {
		if (n==0){
			String str = "";
			for (String s:arr) {
				str = str+s;
			}
			max = Math.max(max,Integer.parseInt(str));
			return;
		}
		for (int i = 0; i <arr.length-1 ; i++) {
			for (int j = i+1; j < arr.length; j++) {
				swap(i, j);
				dsf(n-1);
				swap(i, j);
			}
		}
	}

	private static void swap(int i, int j) {
		String x = arr[i];
		arr[i]=arr[j];
		arr[j]=x;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int testCaseArrNum = 0;
//		int cnt = 0;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			arr = sc.next().split("");
			testCaseArrNum=sc.nextInt();
			max = 0;
			if(arr.length < testCaseArrNum) {	// swap 횟수가 자릿수보다 클 때
				testCaseArrNum = arr.length;	// 자릿수만큼만 옮겨도 전부 옮길 수 있음
			}
			dsf(testCaseArrNum);

			System.out.println("#"+test_case+" "+max);

		}
	}

}
