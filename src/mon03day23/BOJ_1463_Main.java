package mon03day23; 
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1463_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 4];
		Arrays.fill(arr, Integer.MAX_VALUE);

		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;

		for (int i = 4; i <= N; i++) {
			if (i % 3 == 0) {
				arr[i] = Math.min(arr[i / 3] + 1, arr[i]);
			}
			if (i % 2 == 0) {
				arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
			}
			arr[i] = Math.min(arr[i - 1] + 1, arr[i]);
		}
		
		System.out.println(arr[N]);
		sc.close();
	}
}
