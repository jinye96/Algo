package swea.day0323;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1251_Solution {

	static class Vertex implements Comparable<Vertex> {
		int no;
		double edge;

		public Vertex(int no, double input) {
			super();
			this.no = no;
			this.edge = input;
		}

		@Override
		public int compareTo(Vertex o) {
			if (this.edge - o.edge > 0)
				return 1;
			else
				return -1;
			// return (int) (this.edge - o.edge);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] pos = new int[N][2];
			double[][] input = new double[N][N];
			boolean[] visited = new boolean[N];
			double[] minEdge = new double[N];
			PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();

			StringTokenizer st;
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					pos[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			double cost = Double.parseDouble(st.nextToken());
			// System.out.println(cost);

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					input[i][j] = cost * (Math.pow(pos[i][0] - pos[j][0], 2) + Math.pow(pos[i][1] - pos[j][1], 2));
					input[j][i] = cost * (Math.pow(pos[i][0] - pos[j][0], 2) + Math.pow(pos[i][1] - pos[j][1], 2));
				}

			} // i노드에서 j노드까지의 비용을 모두 배열에 저장
			for (int i = 0; i < N; i++) {
				minEdge[i] = Double.MAX_VALUE;
			}
//			for(int i= 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(input[i][j]+ " ");
//				}
//				System.out.println();
//			}
			long result = 0, nodeCount = 0;
			double resultDouble = 0.0;
			minEdge[0] = 0;// 시작점 비용 0 셋팅
			queue.offer(new Vertex(0, 0));

			while (!queue.isEmpty()) {

				Vertex minVertex = queue.poll(); // PQ 에서 간선비용이 최소인 정점 뽑기
				if (visited[minVertex.no])
					continue;

				result += Math.ceil(minVertex.edge);
				resultDouble += (minVertex.edge - Math.ceil(minVertex.edge));

				visited[minVertex.no] = true;
				if (++nodeCount == N)
					break;

				for (int i = 0; i < N; i++) {
					if (!visited[i] && input[minVertex.no][i] != 0 && minEdge[i] > input[minVertex.no][i]) {
						minEdge[i] = (double) input[minVertex.no][i];
						queue.offer(new Vertex(i, input[minVertex.no][i]));
					}
				}
			}
			System.out.println("#" + tc + " " + (result + Math.round(resultDouble)));
		}
	}
}