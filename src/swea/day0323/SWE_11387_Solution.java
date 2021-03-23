package swea.day0323;

import java.math.BigDecimal;
import java.util.Scanner;

public class SWE_11387_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			BigDecimal D = new BigDecimal(sc.nextInt());
			BigDecimal L = new BigDecimal(sc.nextInt());
			BigDecimal percent = new BigDecimal(100);
			int N_int = sc.nextInt();
			BigDecimal  total = new BigDecimal(0);
			
			
			for(int i1 = 0; i1 < N_int; i1++) {
				BigDecimal N = new BigDecimal(i1);
				total = total.add(D.add(N.multiply(L).multiply(D.divide(percent))));
	
			}
			System.out.println("#" + (i + 1) + " " + total);
		}
		
		sc.close();
	}
}
