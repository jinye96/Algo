package sweajw.day0323;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_6808_규영이와인영이의카드게임 {
	static int cntWin, cntLose, caseWin, caseLose, totalCount;
	static boolean[] isSelected;
	static int[] input, input2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			input = new int[9];
			input2 = new int[9];
			boolean[] check = new boolean[19];

			for (int i = 0; i < 9; i++) {
				input[i] = sc.nextInt();
				check[input[i]] = true;
			}
			int cnt = 0;
			for (int i = 1; i < 19; i++) {
				if (!check[i]) {
					input2[cnt++] = i;
				}
			}
			isSelected = new boolean[9];
			cntWin = 0;
			cntLose = 0;
			permutation(0, 0, 0);

			System.out.println("#" + tc + " " + cntWin + " " + cntLose);
		}
		sc.close();
	}

	private static void permutation(int cnt, int caseWin, int caseLose) {
		if (cnt == 9) {
			totalCount++;
			if (caseWin < caseLose) {
				cntWin++;
			} else if (caseWin > caseLose) {
				cntLose++;
			}
			return;
		}
		for (int i = 0; i < 9; ++i) {
			if (isSelected[i])
				continue;
			if (input2[i] < input[cnt]) {
				caseWin += input[cnt] + input2[i];
			} else if(input2[i] > input[cnt]){
				caseLose += input[cnt] + input2[i];
			}
			isSelected[i] = true;
			permutation(cnt + 1, caseWin, caseLose);
			isSelected[i] = false;
		}
	}
}
