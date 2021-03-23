package mon03day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int cnt = 0;
		int[][] arr = new int [100][100];
		for (int paper = 0; paper < num; paper++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			for(int i = x; i < x + 10; i++) {
				for(int j = y; j < y + 10; j++) {
					if(arr[i][j]==0) {
						arr[i][j] = 1;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
		br.close();
	}
}
