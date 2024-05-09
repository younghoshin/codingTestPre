package samsung;

import java.util.*;

import com.sun.jdi.VoidValue;

public class Q_1244 {
	public static int swap(int pbNum,int swapPiont, int swapNum, int[] arr ) {
//		String st = Arrays.toString(arr).replace(", ", "");
//		st=st.substring(1,st.length());
//		int pbNum = Integer.parseInt(st);
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = swapPiont+1; i < arr.length; i++) {
			int swapedNum = transNum(arr,i,swapPiont);
			if (pbNum>swapedNum) {
				if (swapNum%2==0) {
					return pbNum;
				}
				else {
					list.add(swapedNum)
				}
			}
			
		}
		return list.stream().max(x->x);
	}
	private static int transNum(int[] arr,int i,int swapPoint) {
		
		int x = arr[swapPoint];
		arr[swapPoint]=arr[i];
		arr[i] = x; 
		String st = Arrays.toString(arr).replace(", ", "");
		st=st.substring(1,st.length());
		return Integer.parseInt(st);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] str = sc.nextLine().split(" ");
			char [] cArr = str[0].toCharArray();
			int[] arr = new int[cArr.length];
			int swap = Integer.parseInt(str[1]);
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Character.getNumericValue(cArr[i]);
			}
			
		}
	}

}
