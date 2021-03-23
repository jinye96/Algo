package sweajw.day0323;

import java.util.Scanner;

public class SWE_1204_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int tcNum = sc.nextInt();
			int[] score = new int[101];
			int max_count = 0;
			int answer = 0;
			for (int j = 0; j < 1000; j++) {
				score[sc.nextInt()]++;
			}
			for (int j = 0; j < 101; j++) {
				if (score[j] >= max_count) {
					max_count = score[j];
					answer = j;
				}
			}
			System.out.println("#" + tcNum + " " + answer);
		}
		sc.close();
	}
}
