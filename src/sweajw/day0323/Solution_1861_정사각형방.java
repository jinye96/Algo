package sweajw.day0323;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int [N][N];
			int[] ans = new int [2]; // 방 번호, 이동 가능한 방의 수
			
			for (int row = 0; row < N; row++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int col = 0; col < N; col++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
				}
			}	// 입력
			
			for (int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int temp = moveRoom(arr, i, j);	// 방 개수 카운트
					if(temp > ans [1]) {
						ans[0] = arr[i][j];
						ans[1] = temp;
					}else if(temp == ans[1]) {
						if(arr[i][j] < ans[0] || ans[0] == 0) {
							ans[0] = arr[i][j];
							ans[1] = temp;
						}
					}
				}
			}
			// 출력
			System.out.println("#" + tc + " " + ans[0] + " " + ans[1]);
		}
		br.close();
	}

	private static int moveRoom(int[][] map, int i, int j) {
		int[] posX = {-1,  1,  0,  0};
		int[] posY = { 0,  0, -1,  1};	// 상하좌우
		int cnt = 1;	// 이동 가능한 방의 수가 없으면 1, 있으면 1에서 증가
		
		while(true) {	// 4방향에 방이 없는 경우에 while를 종료한다.
			for(int dir = 0; dir < 4; dir++) {// 4방 조사
				int tempX = i + posX[dir];
				int tempY = j + posY[dir];
				
				if(tempX < 0 || tempY < 0 || tempX >= map.length || tempY >= map.length) {
					continue;
				}// 맵 영역을 벗어나는 경우
				
				if(map[i][j] + 1 == map[tempX][tempY]) {
					// 이동 가능한 방이 존재하는 경우
					cnt++;
					i = tempX;
					j = tempY;	// 4방향을 측정할 방의 좌표 이동
					dir = -1;	// 방향을 다시 위부터 측정 시작
					continue;
				}
			}
			break;	// 4방의 조사가 모두 완료된 경우 while문 종료
		}
		return cnt;	// 이동한 방의 수 리턴
	}
	
}
