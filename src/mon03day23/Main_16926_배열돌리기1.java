package mon03day23;
import java.util.Scanner;
 
public class Main_16926_배열돌리기1 {

	static int[][] arr1, arr2;
	static int N, M, R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		arr1 = new int[N][M];
		arr2 = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr1[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < R; i++) {
			if (i % 2 == 0)
				rotate(arr1, arr2);
			else
				rotate(arr2, arr1);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print((R % 2 == 0 ? arr1[i][j] : arr2[i][j]) + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static void rotate(int[][] from, int[][] to) {
		for (int i = 0; i < from.length / 2; i++) {
			for (int j1 = i + 1; j1 < from[0].length - i; j1++) {
				to[i][j1 - 1] = from[i][j1];
				to[N - 1 - i][M - j1] = from[N - 1 - i][M - 1 - j1];
			}
		}
		for (int i = 0; i < from[0].length / 2; i++) {
			for (int j3 = i; j3 < from.length - (i + 1); j3++) {
				to[j3 + 1][i] = from[j3][i];
				to[N -2 - j3][M - 1 - i] = from[N - 1 - j3][M - 1 - i];
			}
		}
	}
}
