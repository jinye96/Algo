package sweajw.day0323;

import java.util.Scanner;

public class SWE_1974_Solution {
	public static boolean sudoku(int arr[][]) {
		boolean check = true;

		for (int i = 0; i < 9; i++) {
			boolean[] checkRow = new boolean[10];
			boolean[] checkCol = new boolean[10];
			for (int j = 0; j < 9; j++) {
				if (!checkRow[arr[i][j]]) {
					checkRow[arr[i][j]] = true;
				} else {
					//System.out.println(i + " " + j + "row");
					check = false;
				}
				if (!checkCol[arr[j][i]]) {
					checkCol[arr[j][i]] = true;
				} else {
					//System.out.println(i + " " + j + "col");
					check = false;
				}
				if ((i % 3 == 0) && (j % 3 == 0)) {
					boolean[] checkBox = new boolean[10];
					for (int p = 0; p < 3; p++) {
						for (int q = 0; q < 3; q++) {
							if (!checkBox[arr[i + p][j + q]]) {
								checkBox[arr[i + p][j + q]] = true;
							} else {
								//System.out.println(i + " " + j + "box");
								check = false;
							}
						}
					}
				}
			}
		}
		
		return check;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {

			int[][] puzzle = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			if (sudoku(puzzle)) {
				System.out.println("#" + testcase + " 1");
			} else {
				System.out.println("#" + testcase + " 0");
			}

		}
		sc.close();
	}
}
