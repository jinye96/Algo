package sweajw.day0323;
import java.util.Scanner;

public class Solution_0201_원재의메모리복구하기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			
			int count = 0;	// 수정 횟수
			String str = sc.next();
			char[] compareStr = {'0', '1'};
			
			for (int j = 0; j < str.length(); j++) {
				
				if((count % 2 == 0) && (str.charAt(j) == compareStr[1])) {
					count++;
				}
				else if((count % 2 == 1) && (str.charAt(j) == compareStr[0])) {
					count++;
				}
			}
			
			System.out.println("#" + (i + 1) + " " + count );
			
		}
		sc.close();
	}
}
