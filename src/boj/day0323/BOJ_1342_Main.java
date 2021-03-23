package boj.day0323;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1342_Main {
	static char[] input;
	static char[] output;
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		input = new char[s.length()];
		int[] alpha = new int[26];
		for (int i = 0; i < s.length(); i++) {
			input[i] = s.charAt(i);
			alpha[s.charAt(i) - 'a']++;
		}
		visited = new boolean[input.length];
		output = new char[s.length()];

		ans = 0;
		permutation(0);
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] > 1) {
				ans = ans / factorial(alpha[i]);
			}
		}
		System.out.println(ans);
		sc.close();

	}

	private static int factorial(int n) {
		int r = 1;
		for (int i = n; i >= 1; i--) {
			r = r * i;
		}
		return r;
	}

	private static void permutation(int cnt) {
		if (cnt >= input.length) {
			// if(output[input.length-1]!=output[input.length-2]) {
			for (int j = 1; j < input.length; j++) {
				if (output[j] == output[j - 1]) {
					return;
				}
			}
			ans++;
			System.out.println(Arrays.toString(output));
			return;
		}
		for (int i = 0; i < input.length; i++) {

			if (visited[i])
				continue;

			// if(cnt > 0) {if(input[i] == output[cnt - 1]) continue;}

			visited[i] = true;
			output[cnt] = input[i];
			permutation(cnt + 1);
			visited[i] = false;
		}
	}
}
