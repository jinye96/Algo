package sweajw.day0323;

import java.util.Scanner;

public class SWE_1945_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++) {
			int a=0, b=0, c=0, d=0, e=0;
			int num = sc.nextInt();
			while(num != 1) {
				if(num % 11==0) {
					e++;
					num /= 11;
				}if(num % 7==0) {
					d++;
					num /= 7;
				}if(num % 5==0) {
					c++;
					num /= 5;
				}if(num % 3==0) {
					b++;
					num /= 3;
				}if(num % 2==0) {
					a++;
					num /= 2;
				}
			}
			System.out.println("#" + i + " " + a + " " + b + " " +
								c + " " + d + " " + e);
		}
		sc.close();
		
	}
}
