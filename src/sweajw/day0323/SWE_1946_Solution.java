package sweajw.day0323;

import java.util.Scanner;

public class SWE_1946_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			int count = 0;
			String[] Ci = new String [N];
			int[] CiNum = new int [N];
			for (int i = 0; i < N; i++) {
				Ci [i] = sc.next();
				CiNum [i] = sc.nextInt();
			}
			System.out.println("#" + testcase);
			for (int i = 0; i < N; i++) {
				for(int j = 0; j < CiNum[i]; j++) {
					if(count==10) {
						count = 0;
						System.out.println();
					}
					System.out.print(Ci[i]);
					count++;
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
