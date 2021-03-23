package swea.day0323;

import java.util.Scanner;

public class SWE_1959_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			for(int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for(int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			int answer = getDotProduct(A, B);
			
			System.out.println("#" + testcase + " " + answer);
		}
		
		sc.close();
	}
	private static int getDotProduct(int[] A, int[] B) {
		int ALong = A.length - B.length > 0 ? A.length - B.length : -1;
		int BLong = B.length - A.length > 0 ? B.length - A.length : -1;
		int maxProduct = 0;
		int tempProduct = 0;
		for(int i = 0; i <= ALong; i++) {
			tempProduct = 0;
			for(int p = i; p < i + B.length; p++) {
				tempProduct += A[p] * B[p - i];
			}
			if(maxProduct < tempProduct)
				maxProduct = tempProduct;
		}
		for(int i = 0; i <= BLong; i++) {
			tempProduct = 0;
			for(int p = i; p < i + A.length; p++) {
				tempProduct += A[p - i] * B[p];
			}
			if(maxProduct < tempProduct)
				maxProduct = tempProduct;
		}
		if(ALong == 0 && BLong == 0) {
			tempProduct = 0;
			for(int p =0; p < A.length; p++) {
				tempProduct += A[p] * B[p];
			}
			if(maxProduct < tempProduct)
				maxProduct = tempProduct;
		}

		return maxProduct;
	}
}
