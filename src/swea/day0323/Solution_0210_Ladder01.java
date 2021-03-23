package swea.day0323;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_0210_Ladder01 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int T = 0; T < 10; T++) {
			int testcaseNum = Integer.parseInt(br.readLine());
			int[][] array = new int[101][101];
			int answer = -1;

			///////// 입력/////////
			for (int i = 0; i < 100; i++) {
				StringTokenizer tokens = new StringTokenizer(br.readLine());

				for (int j = 0; j < 100; j++) {
					array[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			///////// 연산/////////
			for (int i = 0; i < 100; i++) {
				int ans = -1;
				if (array[99][i] == 2) {
					System.out.print("#" + testcaseNum + " ");
					checkLadder(array, 99, i, 2);
					System.out.println();
					
				}
				
			}
		}
	}

	private static void checkLadder(int[][] array, int posRow, int posCol, int dir) {

		int[] row = { 0, 0, -1 };
		int[] col = { -1, 1, 0 }; // 좌 , 우, 상
		//System.out.println("지금 위치는?" + posRow + "," +posCol);
		for (int i = 0; i < 3; i++) {
			int tempX = posRow + row[i];
			int tempY = posCol + col[i];
			if ((tempY < 0) || (tempY > array.length - 1)) {
				continue; 			// 사다리 영역을 벗어난 경우
			}
			if(dir < 2 && dir != i && i < 2) {	// 왔던 길로 다시 돌아가는 경우(올라가는 경우 제외)
				continue;
			}
			if (tempX == 0) { 		// 사다리의 끝에 도착한 경우
				System.out.print(tempY);
			}
			if (tempX > 0) { 		// 사다리의 끝에 도착하지 않은 경우
				if (array[tempX][tempY] == 1) {
					checkLadder(array, tempX, tempY, i);
					break;
				}
			}
			
		}
	}
}
