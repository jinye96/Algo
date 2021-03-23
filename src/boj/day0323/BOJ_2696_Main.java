package boj.day0323;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2696_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt();
			//System.out.println(M);
			LinkedList<Integer> list = new LinkedList<>();
			System.out.println(((M / 2) + 1));
			for (int i = 1; i <= M; i++) {
				list.add(sc.nextInt());
				if (i % 2 == 1) {
					list.sort(null);
					System.out.print(list.get(list.size() / 2) + " ");
				}
				if (i % 20 == 0) {
					System.out.println();
				}
				//System.out.println(list);
			}
			System.out.println();
		}
		sc.close();
	}
}
