package swea.day0323;

import java.util.Scanner;

public class SWE_1970_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			int oMan = N / 50000;
			int Man = (N - oMan * 50000)/10000;
			int oChun = (N % 10000)/5000;
			int chun  = ((N % 10000)- oChun * 5000)/1000;
			int oBak  = ((N % 10000) % 1000)/500;
			int bak   = (((N % 10000) % 1000) - oBak * 500)/100;
			int oShip = (((N%10000)%1000)%100)/50;
			int ship  = ((((N%10000)%1000)%100) - oShip * 50)/10;
			
			System.out.println("#" + testcase);
			System.out.println(oMan + " " + Man  + " " + oChun  + " " + chun  + " " + 
			oBak + " " + bak + " " + oShip + " " + ship	);
		}
		
		sc.close();
	}
}
