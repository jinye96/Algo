package mon03day23;

import java.util.Scanner;

public class SWE_1979_Solution {
	private static int getPuzzle(int[][] puzzle, int K) {
		int count = 0;
		for (int i = 0; i < puzzle.length; i++) {
			int checkRow = 0;
			int checkCol = 0;
			for (int j = 0; j < puzzle.length; j++) {
				if(puzzle[i][j]==0) {
					if(checkRow==K)
						count++;
					checkRow = 0;
				}
				else{
					checkRow++;
				}
				if(puzzle[j][i]==0) {
					if(checkCol==K)
						count++;
					checkCol = 0;
				}
				else {
					checkCol++;
				}
				//System.out.println(i + " "+ j + " "+ checkRow + " "+ checkCol);
				if(j == puzzle.length -1) {
					if(checkRow==K)
						count++;
					if(checkCol==K)
						count++;
				}
			}
		}
		
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] puzzle = new int [N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			int answer = getPuzzle(puzzle, K);
			System.out.println("#"+ testcase + " " + answer);
		}
		sc.close();
	}
}
