package mon03day23;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1238_Solution {
	static int maxN = 100;
	static int[][] contact;
	static int[] visit;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 10;
		for (int tc = 1; tc <= t; tc++) {
			int l = sc.nextInt(); // 데이터 길이
			int s = sc.nextInt(); // 시작
			contact = new int[maxN + 1][maxN + 1];
			visit = new int[maxN + 1];
			for (int i = 0; i < l/2; i++) {
				int su1 = sc.nextInt();
				int su2 = sc.nextInt();
				contact[su1][su2] = 1;
			}

			Queue<Integer> queue = new LinkedList<>();
			visit[s] = 1;
			queue.offer(s);
			while (!queue.isEmpty()) {
				max = 0;
				int size = queue.size();
				for (int j = 0; j < size; j++) {
					int temp = queue.poll();
					if (max < temp)
						max = temp;

					for (int k = 1; k <= maxN; k++) {
						if (contact[temp][k] == 1 && visit[k] == 0) {
							visit[k] = 1;
							queue.offer(k);
						}
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
		sc.close();
	}

}
