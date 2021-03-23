package mon03day23;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1227_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res = 0;
		int[][] map;
		int sx = 0, sy = 0, ex = 0, ey = 0;
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 }; // 상하좌우
		for (int tc = 1; tc <= 10; tc++) {
			res = 0;
			sc.nextInt();
			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				String s = sc.next();
				for (int j = 0; j < 100; j++) {
					map[i][j] = s.charAt(j) - '0';
					if (map[i][j] == 2) {
						sx = j;
						sy = i;
						map[i][j] = 1;
					} else if (map[i][j] == 3) {
						ex = j;
						ey = i;
					}
				}
			}
			boolean[][] v = new boolean[100][100];
			Queue<Data> q = new LinkedList<>();

			q.offer(new Data(sx, sy));
			v[sy][sx] = true;
			Data cur = null;
			int nx, ny;
			while (!q.isEmpty()) {
				cur = q.poll();
				//System.out.println(cur.x + " " + cur.y);
				// 도착지점 이라면
				if (cur.x == ex && cur.y == ey) {
					res = 1;
					break;
				}
				// 도착지점이 아니라면
				// 4방위 범위를 체크한다.
				for (int d = 0; d < 4; d++) {
					nx = cur.x + dx[d];
					ny = cur.y + dy[d];
					if (map[ny][nx] == 1) {
						continue;
					}
					if(!v[ny][nx]) {
						v[ny][nx] = true;
						q.offer(new Data(nx, ny));
					}
				}
			}
			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

	static class Data {
		int x, y;

		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
