package mon03day23;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1759_Main {
	
	static String [] input; 
	static String [] output;
	static int n, c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		c = sc.nextInt();
		input = new String[c];
		output = new String[n];
		
		for(int i = 0; i < c; i++) {
			input[i] = sc.next();
		}
		Arrays.sort(input);
		combination(0, 0);
		sc.close();
	}
	private static void combination(int cnt, int start) {
		if(cnt == n) {
			int cnt_mo = 0;
			for(int i= 0; i < n; i++) {
				if(output[i].equals("a")||output[i].equals("e")||
						output[i].equals("i")||output[i].equals("o")||output[i].equals("u")) {
					cnt_mo++;
				}
			}
			if(cnt_mo > 0 && n - cnt_mo > 1) {
				for(int i= 0; i < n; i++) {
					System.out.print(output[i]);
				}
				System.out.println();
			}
			return;
		}
		for(int i = start; i < c; i++) {
			output[cnt] = input[i];
			combination(cnt+1, i + 1);
		}
	}
}
