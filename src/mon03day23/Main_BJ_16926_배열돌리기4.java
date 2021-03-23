package mon03day23;
import java.util.Scanner;
 
public class Main_BJ_16926_배열돌리기4 {
	static int N, M, R;
	static int[] dy = { 0, 1, 0, -1 };// 행인덱스
	static int[] dx = { 1, 0, -1, 0 };// 열인덱스

	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 배열의 크기 N*M
		N = sc.nextInt(); // 행크기
		M = sc.nextInt(); // 열크기
		R = sc.nextInt(); // 회전 수

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();// 배열 숫자 입력
			}
		}

		int s = Math.min(N, M) / 2;

		for (int i = 0; i < R; i++) {// 회전수만큼 반복
			rotate(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		int sum = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int temp = 0;
			for (int j = 0; j < M; j++) {
				temp += arr[i][j];
				// System.out.print(arr[i][j] + " ");//회전 결과 출력
			}
			if (temp < sum)
				sum = temp;
			// System.out.println();
		}
		System.out.println(sum);
		sc.close();
	}// main

	public static void rotate(int r, int c, int s) {
        for (int i = 0; i < s * 2 + 1; i++) {
        	
            int dir = 0;//우   아   좌    상
            int sy = i + r - s - 1; //rotate 시작위치 행
            int sx = i + c - s - 1; //rotate 시작위치 열
            int value = arr[sy][sx]; 
            
            while (dir < 4) {//dir=0,1,2,3
                int ny = sy + dy[dir];//ny = 0, 0, 0
                int nx = sx + dx[dir];//nx = 1, 2, 3
 
                if (ny >= i && nx >= i && ny < r + s - 1 - i && nx < c + s - 1 - i) {//배열의 범위를 넘어섰다면, 바깥 로테이션 범위를 넘어섰다면
                    arr[sy][sx] = arr[ny][nx]; //값 시프트
 
                    sy = ny; //이동
                    sx = nx; //이동
                } else {
                    dir++;
                }
            }
           // arr[ + 1][i] = value;
        }
    }
}