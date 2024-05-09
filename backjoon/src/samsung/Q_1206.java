package samsung;

import java.util.Scanner;



public class Q_1206 {
		public static void main(String args[]) throws Exception
		{
	
			Scanner sc = new Scanner(System.in);
			int T;
			for (int i = 1; i <=10; i++) {
				T=sc.nextInt();
				int[] intArr = new int[T];
				for (int j = 0; j < T; j++) {
					intArr[j] = sc.nextInt();
				}
				int count = 0;
				for(int test_case = 2; test_case < T-2; test_case++)
				{
				
					int left = 0;
					int right = 0;
					int maxHigh = 0;
					
					if (intArr[test_case-2]>=intArr[test_case-1]) {
						left = intArr[test_case-2];
					}else {
						left = intArr[test_case-1];
					}
					if (intArr[test_case+2]>=intArr[test_case+1]) {
						right = intArr[test_case+2];
					}else {
						right = intArr[test_case+1];
					}
					maxHigh = left >= right ? left : right;
//	                int max = Math.max(intArr[test_case - 2], Math.max(intArr[test_case - 1], 
//	                				Math.max(intArr[test_case + 1], intArr[test_case + 2])));

	                
	                count = intArr[test_case]>maxHigh ? 
							count+(intArr[test_case]-maxHigh) :
								count;
					
				}
				System.out.println("#"+i+" "+count);
				
			}
			sc.close();
			
		}
}
