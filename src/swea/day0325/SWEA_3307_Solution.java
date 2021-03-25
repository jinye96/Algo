package swea.day0325;
import java.util.Scanner;

public class SWEA_3307_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int ans = 0;
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] length = new int[n];
			for(int i= 0; i < n; i++) {
				arr[i] = sc.nextInt();
				length[i] = 1;
			}
			for(int i= 1; i < n; i++) {
				for(int j = i-1; j > -1; j--) {
					if(arr[i] > arr[j]) {
						length[i] = Math.max(length[j] + 1, length[i]);
					}
				}
			}
			for(int i= 0; i < n; i++) {
				ans = Math.max(ans, length[i]);
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
