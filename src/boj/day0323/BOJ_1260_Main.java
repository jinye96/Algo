package boj.day0323; 
import java.util.Scanner;

public class BOJ_1260_Main {
	static int n, m, cnt;
	static boolean[][] visited;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		cnt = 0;
		n = sc.nextInt();
		m = sc.nextInt();

		int startX, startY, startD;
		startX = sc.nextInt();
		startY = sc.nextInt();
		startD = sc.nextInt();

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		checkCnt(startX, startY, startD, 0);
		System.out.println(cnt);

		sc.close();
	}

	private static void checkCnt(int X, int Y, int D, int flag) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		if(!visited[X][Y]) {//현 위치 청소 안한 경우에만 청소.
			System.out.println(X + " " + Y);
			visited[X][Y] = true;
			cnt++; // 현재 위치를 청소한다.
		}
		if(D==0) D = 3;
		else if(D==1) D = 2;
		else if(D==2) D = 1;
		else D = 0;
		int nx = X + dx[D];
		int ny = Y + dy[D];
		if(nx > 0 && nx < n && ny > 0 && ny < m && map[nx][ny] == 0 && !visited[nx][ny]) {
			// a. 왼쪽 뱡향 청소 안한 경우 한칸 전진
			checkCnt(nx, ny, D, 0);
		}else{
			if(flag==4) {//네 방향을 모두 확인한 경우
				int tempD = 0;
				if(D==0) tempD = 3;
				else if(D==1) tempD = 2;
				else if(D==2) tempD = 1;
				else tempD = 0;
				nx = X + dx[tempD];
				ny = Y + dy[tempD];
				if(nx > 0 && nx < n && ny > 0 && ny < m && map[nx][ny] == 0) {
					checkCnt(nx, ny, D, 0);
				}
				else {
					return;
				}
			}else{
				checkCnt(X, Y, D, flag + 1);//다시 돌아간다.
			}
		}
	}
}
