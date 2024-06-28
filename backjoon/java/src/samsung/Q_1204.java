package samsung;
import java.util.*;

//Solution
public class Q_1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int[] testCaseArr = new int[T];
		int[] maxArr = new int[T];
		List<Integer> list = new ArrayList<Integer>();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int max = 0;
			int topValue = 0;
			int[] arr = new int[101];
			
			int n = sc.nextInt();
			sc.nextLine();
			testCaseArr[test_case-1] = n;
			String[] strArrStrings = sc.nextLine().split(" ");
			for (int i = 0; i < strArrStrings.length; i++) {
				int value = Integer.parseInt(strArrStrings[i]);
				arr[value]++;
			}
			for (int i = 0; i < arr.length; i++) {
				if (arr[i]>=max) {
					max = arr[i];
					topValue=i;
				}
			}
			maxArr[test_case-1] = topValue;
			
					
		}
		
		for (int i = 0; i < T; i++) {
			System.out.println("#"+testCaseArr[i]+" "+maxArr[i]);
		}
		sc.close();
	}
}
