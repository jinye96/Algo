package swea.day0323;

import java.util.Scanner;

public class SWE_1961_Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			String[] answer = new String[N];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j > -1; j--) {
					if(answer[count] == null)
						answer[count] = String.valueOf(arr[j][i]);
					else
						answer[count] += arr[j][i];
				}
				answer[count++] += " ";
			}
			count = 0;
			for (int i = N - 1; i > -1; i--) {
				for (int j = N - 1; j > -1; j--) {
					answer[count] += arr[i][j];
				}
				answer[count++] += " ";
			}
			count = 0;
			for (int i = N - 1; i > -1; i--) {
				for (int j = 0; j < N; j++) {
					answer[count] += arr[j][i];
				}
				answer[count++] += " ";
			}
			System.out.println("#" + testcase);
			for (int i = 0; i < N; i++) {
				System.out.println(answer[i]);
			}
		}
		sc.close();
	}
}
