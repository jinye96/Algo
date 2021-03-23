package swea.day0323;

import java.util.Scanner;

public class SWE_1285_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T ; testcase++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			int A = P * W;
			int B = (W > R) ? (Q + (W - R) * S) : Q ;
			int answer = A > B ? B : A;
			System.out.println("#" + testcase + " " + answer);
		}
		sc.close();
	}
}
