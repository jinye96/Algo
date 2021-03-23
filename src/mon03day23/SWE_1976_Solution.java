package mon03day23;

import java.util.Scanner;

public class SWE_1976_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int testcase = 1; testcase <= T; testcase++) {
			int []clock = new int[4];
			for (int i = 0; i < 4; i++) {
				clock[i] = sc.nextInt();
			}
			int si = 0;
			if(((clock[0] + clock[2] + ((clock[1] + clock[3])/60)) % 12 == 0)){
				 si = 12;
			}
			else {
				 si = (clock[0] + clock[2] + ((clock[1] + clock[3])/60)) % 12;
			}
			System.out.println("#" + testcase + " " + 
			si + " " + (clock[1] + clock[3]) % 60);
		}
		sc.close();
	}
}
