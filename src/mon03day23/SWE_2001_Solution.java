package mon03day23;

import java.util.Scanner;

public class SWE_2001_Solution {
	public static int killFly(int[][] arr, int M) {
		//죽인 파리의 개수를 출력하는 메서드
		int flyNumMax = 0;								 // 죽인 파리의 최댓값
		for(int i = 0; i < arr.length - M + 1; i++) {	
			for(int j = 0; j < arr.length - M + 1; j++) {// 기준점 잡기
				int flyNum = 0;							 // 죽인 파리의 개수
				for (int k = 0; k < M; k++) {
					for (int k2 = 0; k2 < M; k2++) {
						flyNum += arr[i + k][j + k2];
					}
				}
				if(flyNumMax < flyNum)
					flyNumMax = flyNum;
			}
		}
		return flyNumMax;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 0; testcase < T; testcase++) {
			// 배열 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int [][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int answer = killFly(arr, M);
			System.out.println("#"+ (testcase+1) + " " +answer);
		}
		sc.close();
	}
}
