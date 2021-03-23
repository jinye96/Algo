package mon03day23;
import java.util.Scanner;

public class Solution_9229_한빈이와SpotMart2 {
	static int[] arr;
	static int N, M;
	static int maxWeight;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 과자 봉지
			M = sc.nextInt();// 초과 제한 그램수
			arr = new int[N];
			isSelected = new boolean[N];
			for (int nc = 0; nc < N; nc++) {
				arr[nc] = sc.nextInt();
			}
			maxWeight = 0;
			checkWeight(0, 0);
			System.out.println("#" + tc + " " + maxWeight);
		}
		sc.close();
	}
	
	private static void checkWeight(int l, int cnt) {
		if(cnt==N) {
			int sum = 0;
			int cookie = 0;
			for(int i=0; i<N; ++i) {
				if(isSelected[i]) {
					sum += arr[i];
					cookie++;
				}
			}
			if(sum > maxWeight && l <= M && cookie == 2) {
				maxWeight = sum;
			}
			if(maxWeight == 0 && cookie < 2) {
				maxWeight = -1;
			}
			return;
		}
		isSelected[cnt] = true;
		checkWeight(l + arr[cnt], cnt+1);
		isSelected[cnt] = false;
		checkWeight(l, cnt+1);
	}
}