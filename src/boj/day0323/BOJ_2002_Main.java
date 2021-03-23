package boj.day0323;

import java.util.Scanner;

public class BOJ_2002_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String [] input = new String[N];
		int [] output = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.next();
		}
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < N; j++) {
				if(str.equals(input[j])) {
					output[i] = j;
					break;
				}
			}
		}
		//System.out.println(Arrays.toString(output));
		int cnt = 0;
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				if(output[i] > output[j]) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
