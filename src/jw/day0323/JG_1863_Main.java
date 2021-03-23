package jw.day0323;
import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JG_1863_Main {
	static int n, m;
	static int[] parents;
	static boolean[] visited;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		parents = new int[n + 1];
		visited = new boolean[n + 1];
		res = 0;
		for (int i = 1; i < n + 1; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			union(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
		}
		for (int i = 1; i < n + 1; i++) {
			if (parents[i] == i) {
				res++;
			}
		}
		System.out.println(res);
		br.close();
	}

	private static void union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		if (aroot == broot)
			return;
		else
			parents[broot] = aroot;
		return;
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
}
