package mon03day23;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_17471_Main {

	static int N; // 도시의 수
	static int[] p; // 도시의 인구수
	static int[] parent; // 도시 연결관리 인접 행렬
	static int[] teams; // 두 개의 팀
	static ArrayList<link> unions;
	static int res;

	static class link {
		int x;
		int y;

		public link(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("link [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append("]");
			return builder.toString();
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		p = new int[N + 1];
		parent = new int[N + 1];
		teams = new int[N + 1];
		res = Integer.MAX_VALUE;
		unions = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			p[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		//System.out.println(Arrays.toString(parent));
		int cnt = 0;
		int k = 0;
		for (int i = 1; i <= N; i++) {
			cnt = sc.nextInt();
			for (int j = 0; j < cnt; j++) {
				k = sc.nextInt();
				link l = new link(i, k);
				unions.add(l);
			}
		}
		//System.out.println(unions);
		dfs(0);

		System.out.println((res == Integer.MAX_VALUE) ? -1 : res);
		sc.close();
	}

	private static void union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		if (aroot != broot) {
			parent[aroot] = broot;
		}
		//System.out.println(Arrays.toString(parent));
	}

	private static int find(int a) {
		if (parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}

	private static void dfs(int cnt) {
		if (cnt == N + 1) {
			// 인접여부 확인
			for (int i = 0; i < unions.size(); i++) {
				//System.out.println(unions.get(i).x + " "+ unions.get(i).y);
				if (teams[unions.get(i).x] == teams[unions.get(i).y]) {
					union(unions.get(i).x, unions.get(i).y);
				}
			}
			int cnt_parent = 0;
			for (int i = 1; i <= N; i++) {
				if (parent[i] == i)
					cnt_parent++;
			}
			
			int left = 0;
			int right = 0;
			
			if (cnt_parent == 2) {
				for (int k = 1; k <= N; k++) {
					if (teams[k] == 0) {
						left += p[k];
					} else {
						right += p[k];
					}
				}
				res = Math.min(res, Math.abs(left - right));
			}
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			return;
		}
		teams[cnt] = 0;
		dfs(cnt + 1);
		teams[cnt] = 1;
		dfs(cnt + 1);
	}
}
