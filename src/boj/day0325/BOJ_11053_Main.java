package boj.day0325;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] length = new int[n];
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i= 0; i < n; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
			
		}
		for(int i= 0; i < n; i++) {
			for(int j = i-1; j > -1; j--) {
				if(arr[i] > arr[j]) {
					length[i] = Math.max(length[j] + 1, length[i]);
				}
			}
		}
		for(int i= 0; i < n; i++) {
			ans = Math.max(ans, length[i]);
		}
		System.out.println(ans);
	}
}
