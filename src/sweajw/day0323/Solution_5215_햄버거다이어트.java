package sweajw.day0323;
import java.util.Scanner;

public class Solution_5215_햄버거다이어트 {
	
	static int[][] arr;
	static int N, L;
	static int maxMeal;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();//재료의 수
			L = sc.nextInt();//칼로리 제한
			arr = new int[N][2];
			isSelected = new boolean[N];
			for (int nc = 0; nc < N; nc++) {
				arr[nc][0] = sc.nextInt();
				arr[nc][1] = sc.nextInt();
			}
			maxMeal = 0;
			checkMeal(0, 0);
			System.out.println("#" + tc + " " + maxMeal);
		}
		sc.close();
	}
	
	private static void checkMeal(int l, int cnt) {
		if(cnt==N) {
			int sum = 0;
			for(int i=0; i<N; ++i) {
				if(isSelected[i]) sum += arr[i][0];
			}
			if(sum > maxMeal && l <= L) {
				maxMeal = sum;
			}
			return;
		}
		isSelected[cnt] = true;
		checkMeal(l + arr[cnt][1], cnt+1);
		isSelected[cnt] = false;
		checkMeal(l, cnt+1);
	}
}
