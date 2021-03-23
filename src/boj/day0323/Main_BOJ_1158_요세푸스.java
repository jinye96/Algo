package boj.day0323;
import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_1158_요세푸스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		int cnt = 0;
		int idx = 0;
		int temp = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(cnt < N - 1) {
			if(temp < K) {
				idx++;
				if(idx == N) {
					idx = 0;
				}
				if(arr[idx]!=0) {
					temp++;
				}
			}
			if(temp == K) {
				temp = 0;
				while(true) {
					if(arr[idx] != 0) {
						sb.append(arr[idx] + ", ");
						arr[idx] = 0;
						cnt++;
						System.out.println(Arrays.toString(arr));
						break;
					}
					idx++;
				}
			}
			if(idx == N) {
				idx = 0;
			}
		}
		for (int i = 0; i < N; i++) {
			if(arr[i] != 0) {
				sb.append(arr[i]+">");
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
