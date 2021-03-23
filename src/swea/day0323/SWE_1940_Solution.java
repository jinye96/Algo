package swea.day0323;

import java.util.Scanner;

public class SWE_1940_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			int distance = 0, velocity = 0, accel = 0;
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				int status = sc.nextInt();
				if(status == 1) {
					accel = sc.nextInt();
					velocity = (velocity + accel);
				}else if(status == 2) {
					accel = sc.nextInt();
					velocity = (velocity - accel) > 0 ? velocity - accel : 0;  
				}
				distance += velocity;
			}
			System.out.println("#" + testcase + " " + distance);
		}
		sc.close();
	}
}
