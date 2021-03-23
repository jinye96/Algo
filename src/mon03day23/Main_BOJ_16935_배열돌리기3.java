package mon03day23;

import java.util.Scanner;

public class Main_BOJ_16935_배열돌리기3 {
	static int N, M;
	static int[][] subArr1, subArr2, subArr3, subArr4;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < R; i++) {
			switch (sc.nextInt()) {
			case 1:
				udReverse(arr);
				break;
			case 2:
				lrReverse(arr);
				break;
			case 3:
				arr = rightRotate(arr);
				break;
			case 4:
				arr = leftRotate(arr);
				break;
			case 5:
				rightGroupRotate(arr);
				break;
			case 6:
				leftGroupRotate(arr);
				break;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static void udReverse(int[][] arr) {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[N - 1 - i][j];
				arr[N - 1 - i][j] = temp;
			}
		}
	}

	private static void lrReverse(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][M - 1 - j];
				arr[i][M - 1 - j] = temp;
			}
		}
	}

	private static int[][] rightRotate(int[][] arr) {
		int[][] temp = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[j][N - 1 - i] = arr[i][j];
			}
		}
		int t = M;
		M = N;
		N = t;
		return temp;
	}

	private static int[][] leftRotate(int[][] arr) {
		int[][] temp = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[M - 1 - j][i] = arr[i][j];
			}
		}
		int t = M;
		M = N;
		N = t;
		return temp;
	}

	private static void rightGroupRotate(int[][] arr) {
		makeGroup(arr);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i < N / 2) {
					if (j < M / 2) {
						arr[i][j] = subArr4[i][j];
					} else {
						arr[i][j] = subArr1[i][j - M / 2];
					}
				} else {
					if (j < M / 2) {
						arr[i][j] = subArr3[i - N / 2][j];
					} else {
						arr[i][j] = subArr2[i - N / 2][j - M / 2];
					}
				}
			}
		}
	}

	private static void leftGroupRotate(int[][] arr) {
		makeGroup(arr);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i < N / 2) {
					if (j < M / 2) {
						arr[i][j] = subArr2[i][j];
					} else {
						arr[i][j] = subArr3[i][j - M / 2];
					}
				} else {
					if (j < M / 2) {
						arr[i][j] = subArr1[i - N / 2][j];
					} else {
						arr[i][j] = subArr4[i - N / 2][j - M / 2];
					}
				}
			}
		}
	}

	private static void makeGroup(int[][] arr) {
		subArr1 = new int[N / 2][M / 2];
		subArr2 = new int[N / 2][M / 2];
		subArr3 = new int[N / 2][M / 2];
		subArr4 = new int[N / 2][M / 2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i < N / 2) {
					if (j < M / 2) {
						subArr1[i][j] = arr[i][j];
					} else {
						subArr2[i][j - M / 2] = arr[i][j];
					}
				} else {
					if (j < M / 2) {
						subArr4[i - N / 2][j] = arr[i][j];
					} else {
						subArr3[i - N / 2][j - M / 2] = arr[i][j];
					}
				}
			}
		}
	}
}
