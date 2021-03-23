package sweajw.day0323;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Scanner;

public class SWE_1928_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			String str = sc.next();
			Decoder decoder = Base64.getDecoder();
			byte[] decodeByte = decoder.decode(str);
			
			System.out.print("#"+ testcase + " ");
			for(int i = 0; i < decodeByte.length; i++) {
				System.out.print((char)decodeByte[i]);
				
			}
			System.out.println();
		}
		sc.close();
	}
}
