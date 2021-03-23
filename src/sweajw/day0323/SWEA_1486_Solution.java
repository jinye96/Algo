package sweajw.day0323;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1486_Solution {
	static int n, b;
	static int res;
	static int[] s;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			b = sc.nextInt();
			s = new int[n];
			res = Integer.MAX_VALUE;
			visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				s[i] = sc.nextInt();
			}
			Arrays.sort(s);
			subset(0);
			System.out.println("#" + tc + " " + (res - b));
		}
		sc.close();
	}

	private static void subset(int cnt) {
		if (cnt == n) {
			int height = 0;
			for (int i = 0; i < n; i++) {
				//System.out.println(s[i]+ " ");
				if (visited[i]) {
					height += s[i];
				}
			}
			if (height >= b) {
				res = Math.min(height, res);
			}
			return;
		}
		visited[cnt] = true;
		subset(cnt + 1);
		visited[cnt] = false;
		subset(cnt + 1);
	}
}
