package mon03day23;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14889_Main {
	
	static int n;
	static int[][] map;
	static int[] choose;
	static int res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		choose = new int[n/2];
		res = Integer.MAX_VALUE;

		for(int i = 0; i < n; i++) {
			for(int j = 0; j <n ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		combination(0, 0, 0);
		System.out.println(res);
		sc.close();
	}

	private static void combination(int cnt, int start, int sum) {
		if(cnt == n/2) {
			int [] notchoose = new int [cnt];
			int cntNew = 0;
			for(int j = 0; j < n; j++) {
				boolean flag = true;
				for(int k = 0; k < cnt; k++) {
					if(choose[k]==j)
						flag = false;
				}
				if(flag) notchoose[cntNew++] = j;
			}
			int newSum = 0;
			for(int j = 0; j < cntNew; j++) {
				for(int k = 0; k < cntNew; k++) {
					newSum+= map[notchoose[j]][notchoose[k]];
				}
			}
			if(Math.abs(newSum - sum) < res)
				res = Math.abs(newSum - sum);
			return;
		}
		for(int i = start; i < n; i++) {
			int tempSum = sum;
			for(int j = cnt - 1; j > -1; j--) {
				tempSum += map[i][choose[j]];
				tempSum += map[choose[j]][i];
			}
			choose[cnt] = i;
			combination(cnt + 1, i + 1, tempSum);
		}
	}
}
