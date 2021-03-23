package mon03day23;
import java.util.Scanner;

public class BOJ_17472_Main {
	static int n, m; 
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cnt;
	public static void main(String[] args) {
		// 1. 지역을 구분한다.
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		
		for(int i =0; i < n; i++) {
			for(int j = 0 ; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		cnt = -1;
		for(int i =0; i < n; i++) {
			for(int j = 0 ; j < m; j++) {
				makeMap(i, j);
			}
		}
		
		sc.close();
	}
	private static void makeMap(int x, int y) {
		boolean flag = true;
		if(map[x][y] == 1) {
			map[x][y] = cnt;
			System.out.println(x + " " + y + " " + cnt);
			for(int p = 0; p < 4; p++) {
				int nx = x + dx[p];
				int ny = y + dy[p];
				if(nx >= 0 && nx < n && ny >= 0&& ny < m) {
					if(map[nx][ny] == 1) {
						makeMap(nx, ny);
						flag = false;
					}
				}
			} 
			if(flag) cnt--;
		}
	}
}
