package sweajw.day0323;

import java.util.Scanner;

public class Solution_9229_한빈이와SpotMart {
	static int[] arr;
	static int N, M;
	static int maxWeight;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 과자 봉지
			M = sc.nextInt();// 초과 제한 그램수
			arr = new int[N];
			maxWeight = -1;
			for (int nc = 0; nc < N; nc++) {
				arr[nc] = sc.nextInt();
			}
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if(arr[i] + arr[j] <= M) {
						if(maxWeight < arr[i] + arr[j]) {
							maxWeight = arr[i] + arr[j];
						}
					}
				}
			}
			System.out.println("#" + tc + " " + maxWeight);
			maxWeight = -1;
		}
		sc.close();
	}
}