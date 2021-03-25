package swea.day0325;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1263_Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken());
			int[][] graph = new int[n][n];
			for (int p = 0; p < n; p++) {
				for (int q = 0; q < n; q++) {
					graph[p][q] = Integer.parseInt(stk.nextToken());
					if (p != q && graph[p][q] == 0) {// 자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
						graph[p][q] = Integer.MAX_VALUE;
					}
				}
			}

			for (int k = 0; k < n; ++k) {
				for (int i = 0; i < n; ++i) {
					if (i == k)
						continue; // 출발지와 경유지가 같다면 다음 출발지
					for (int j = 0; j < n; ++j) {
						if (i == j || k == j)
							continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE
								&& graph[i][j] > graph[i][k] + graph[k][j]) {
							graph[i][j] = graph[i][k] + graph[k][j];
						}
					}
				}
			}
			int ans_value = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++) {
				int temp = 0;
				for(int j = 0; j < n; j++) {
					temp += graph[i][j];
				}
				if(temp < ans_value) {
					ans_value = temp;
				}
			}

			System.out.println("#" + tc + " " + ans_value);
		}
		br.close();
	}
}
