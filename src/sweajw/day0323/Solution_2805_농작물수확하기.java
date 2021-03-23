package sweajw.day0323;
import java.util.Scanner;

public class Solution_2805_농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			int[][] farm = new int [N][N];
			for(int i = 0; i < N; i++) {
				 String str = sc.next();
				 String[] strArray = str.split("");
				for (int j = 0; j < N; j++) {
					farm[i][j] = Integer.parseInt(strArray[j]);
				}
			}
			int answer = harvest(farm);
			System.out.println("#" + testcase + " " + answer);
		}
		sc.close();
	}

	private static int harvest(int[][] farm) {
		int total = 0;
		int farmSize = farm.length;

		for (int i = farmSize / 2; i < farmSize; i++) {
			int notHarvest = i - farmSize / 2;	// 수확을 배제할 범위
			for(int j = notHarvest; j < farmSize - notHarvest; j++) {
				total += (farm[i][j] + farm[farmSize-i-1][j]);
				//System.out.println(farm[i][j]+","+ farm[farmSize-i-1][j]);
			}
		}
		for(int i = 0; i < farmSize; i++) {
			total -= (farm[farmSize / 2][i]);
		}
		return total;
	}
}
