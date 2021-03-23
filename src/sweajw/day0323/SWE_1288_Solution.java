package sweajw.day0323;

import java.util.Scanner;

public class SWE_1288_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			int[] num = new int [10];	// 0~9가 나왔는지 확인하는 공간
			int cnt = 0;				// 새로운 숫자를 발견하는 횟수
			int N = sc.nextInt();		// 양의 수
			int temp = N;
			
			while(cnt != 10) {
				String str = Integer.toString(N);
				char[] arr = str.toCharArray();
				for(int i = 0; i < arr.length; i++) {
					if(num[(int)(arr[i]-'0')] == 0) {
						cnt++;
						num[(int)(arr[i]-'0')]++;
					}
				}
				if(cnt == 10)
					break;
				else {
					N += temp;	// 양의 개수를 늘린다.
				}
			}
			System.out.println("#" + testcase + " " +  N);
		}
		sc.close();
	}
}
