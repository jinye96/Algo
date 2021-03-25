package boj.day0325;
import java.util.Scanner;

public class BOJ_9205_Main {
	static boolean ans;
	static int[][] pos;
	static int [][] dist;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < t; tc++) {

			n = sc.nextInt();
			pos = new int[n + 2][2];

			for (int i = 0; i < n + 2; i++) {
				pos[i][0] = sc.nextInt();
				pos[i][1] = sc.nextInt();
			}

			dist = new int [n + 2][n + 2];
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					if((Math.abs(pos[i][0]-pos[j][0]) + Math.abs(pos[i][1]-pos[j][1])) <=1000 && i!= j)
						dist[i][j] = 1;
				}
			}
			boolean[] visited = new boolean[n + 2];
			ans = false;
			dfs(0, visited);
			sb.append(ans == true ? "happy\n" : "sad\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}

	private static void dfs(int x, boolean[] visited) {
		visited[x] = true;
		if (x == n + 1) {
			ans = true;
			return;
		}
		if (dist[x][n + 1] == 1) {
			ans = true;
			return;
		}
		for (int i = 0; i < n + 2; i++) {
			if (x != i && !visited[i] && dist[x][i] == 1) {
				dfs(i, visited);
			}
		}
	}
}
