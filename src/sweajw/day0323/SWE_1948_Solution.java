package sweajw.day0323;

import java.util.Scanner;

public class SWE_1948_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			int monthFirst = sc.nextInt();
			int dayFirst = sc.nextInt();
			int monthSecond = sc.nextInt();
			int daySecond = sc.nextInt();
			int answer = countDay(monthFirst, monthSecond, dayFirst, daySecond);
			System.out.println("#" + testcase + " " + answer);
		}
		sc.close();
	}

	private static int countDay(int monthFirst, int monthSecond, int dayFirst, int daySecond) {
		int days = 0;
		if(monthSecond - monthFirst > 0) {
			if(monthSecond > 11 && monthFirst <= 11) days += 30;
			if(monthSecond > 10 && monthFirst <= 10) days += 31;
			if(monthSecond > 9 && monthFirst <= 9)   days += 30;
			if(monthSecond > 8 && monthFirst <= 8)   days += 31;
			if(monthSecond > 7 && monthFirst <= 7)   days += 31;
			if(monthSecond > 6 && monthFirst <= 6)   days += 30;
			if(monthSecond > 5 && monthFirst <= 5)   days += 31;
			if(monthSecond > 4 && monthFirst <= 4)   days += 30;
			if(monthSecond > 3 && monthFirst <= 3)   days += 31;
			if(monthSecond > 2 && monthFirst <= 2)   days += 28;
			if(monthSecond > 1 && monthFirst <= 1)   days += 31;
			days += (daySecond - dayFirst) + 1;
		}
		else {
			days += daySecond - dayFirst + 1;
		}
		return days;
	}
}
