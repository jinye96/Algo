package boj.day0323;
import java.util.Scanner;
 
public class BOJ_17070_Main {
	static int n;
	static int[][] map;
	static int res = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(2, 1, 0); //가로 세로 대각선(0, 1, 2)
		System.out.println(res);
		sc.close();
	}
	private static void dfs(int x, int y, int d) {
		// 종료 조건
		if(x == n && y == n) {
			res++;
			return;
		}
		// 실행 & 재귀 호출
		int nx = x + 1;
		int ny = y + 1;
		
		if(nx <= n && ny <= n && map[ny][nx] == 0 && map[ny][x] == 0 && map[y][nx] == 0) {
			dfs(nx, ny, 2);
		}
		if(d == 0 || d == 2) {	//세로 방행과 대각선 방향으로 체크 후 재귀호출
			nx = x + 1;
			ny = y;
			if(nx <= n && ny <= n && map[ny][nx] == 0) {
				dfs(nx, ny, 0);
			}
		}
		if(d == 1 || d == 2) {
			nx = x;
			ny = y + 1;
			if(nx <= n && ny <= n && map[ny][nx] == 0) {
				dfs(nx, ny, 1);
			}
		}
	}
}
