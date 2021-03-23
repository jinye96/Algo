package mon03day23;

import java.util.Arrays;
import java.util.Scanner;

public class SWE_7964_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			int[] arr = new int[n + 2];
			for(int i = 1; i < n+1; i++) {
				arr[i] = sc.nextInt();
			}
			arr[0] = 1;
			arr[n + 1] = 1;
			
			int cnt = 0;
			int res = 0;
			
			System.out.println(Arrays.toString(arr));
			
			for (int i = 0; i < n + 2; i++) {
				if(arr[i] == 0) {
					cnt++;
				}
				else {
                    if(cnt >= d){
						res += cnt / d;
                    }
                    cnt = 0;
				}
			}
			System.out.println("#" + tc + " "+ res);
		}
		sc.close();
	}
}
