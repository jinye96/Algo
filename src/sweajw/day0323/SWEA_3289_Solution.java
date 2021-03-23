package sweajw.day0323;
import java.util.Scanner;

public class SWEA_3289_Solution {

	static int[] union;
	
	static int find(int a) {
		if(union[a]==a) return a;
		return union[a] = find(union[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		union[bRoot] = aRoot;
		return true;
	}
	
	static boolean checkUnion(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			union = new int [N + 1];
			
			for(int k = 1; k < N + 1; k++) {
				union[k] = k;
			}
			
			int M = sc.nextInt();
			StringBuilder ans = new StringBuilder();

			for(int cal = 0; cal < M; cal++) {
				
				int check = sc.nextInt();
				int su1 = sc.nextInt();
				int su2 = sc.nextInt();
				
				if(check == 0) {
					union(su1, su2);
				}else {
					if(checkUnion(su1, su2)) {
						ans = ans.append('0');
					}
					else {
						ans = ans.append('1');
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
