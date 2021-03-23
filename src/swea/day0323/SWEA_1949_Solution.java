package swea.day0323;
import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_1949_Solution {
	static int n;
	static int k;
	static int temp_res;
	static ArrayList<Pos> high;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();
			int[][] map = new int[n + 2][n + 2];
			int high_int = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = sc.nextInt();
					if(high_int < map[i][j]) high_int = map[i][j];
				}
			}
			int high_cnt = 0;
			high = new ArrayList<Pos>();
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(map[i][j] == high_int) { 
						high_cnt++;
						Pos p = new Pos(i, j);
						high.add(p);
					}
				}
			}
			
			boolean[][] check = new boolean[n + 2][n + 2];
			int res = 0;
			for (int i = 0; i < high_cnt; i++) {
				temp_res = 0;
				int[] d = { 0, 1, 2, 3 };
				dfs(map, check, high.get(i).x, high.get(i).y, d, true, 1);
				// 0: 상하좌우 확인 // 등산로 공사를 한번 했는지 안했는지 flag
				// 1: ↓: 하좌우만 확인
				// 2: ↑: 상좌우만 확인
				// 3: →: 상하우만 확인
				// 4: ←: 상하좌만 확인
				if (res < temp_res)
					res = temp_res;
			}
			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

	private static void dfs(int[][] map, boolean[][] check, int x, int y, int[] d, boolean b, int distance) {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 }; // 상하좌우
		check[x][y] = true;
		
		//System.out.println(x + " x " + y + " y " + distance + "dist ");
		if (distance > temp_res)
			temp_res = distance;
		
		for (int i = 0; i < d.length; i++) {
			int nx = x + dx[d[i]];
			int ny = y + dy[d[i]];
			int[] d_next = new int[3];
			if(nx < 1 || nx > n+1 || ny < 1 || ny > n+1) continue;
			
			if(check[nx][ny]) continue;
			
			if(map[nx][ny] >= map[x][y] && (!b || (b && map[nx][ny] - map[x][y] > k))) continue;
			
			if (map[nx][ny] != 0 && d[i] == 0) { // 1: ↑
				d_next[0] = 0;
				d_next[1] = 2;
				d_next[2] = 3;
			} else if (map[nx][ny] != 0 && d[i] == 1) { // 2: ↓
				d_next[0] = 1;
				d_next[1] = 2;
				d_next[2] = 3;
			} else if (map[nx][ny] != 0 && d[i] == 2) { // 3: ←
				d_next[0] = 0;
				d_next[1] = 1;
				d_next[2] = 2;
			} else if(map[nx][ny] != 0 && d[i] == 3){ // 4: →
				d_next[0] = 0;
				d_next[1] = 1;
				d_next[2] = 3;
			}
			
			if(map[nx][ny] >= map[x][y]) {
				map[nx][ny] = map[x][y] -1;
				dfs(map, check, nx, ny, d_next, false, distance + 1);
			
			}else {
				dfs(map, check, nx, ny, d_next, true, distance + 1);
			
			}
		}
		
	}
	static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
