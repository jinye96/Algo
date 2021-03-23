package swea.day0323;
/*

.	평지(전차가 들어갈 수 있다.)			==> 0
 *	벽돌로 만들어진 벽					==> 1
#	강철로 만들어진 벽					==> -1
-	물(전차는 들어갈 수 없다.)				==> -2
^	위쪽을 바라보는 전차(아래는 평지이다.)	==> 2
v	아래쪽을 바라보는 전차(아래는 평지이다.)	==> 3
<	왼쪽을 바라보는 전차(아래는 평지이다.)	==> 4
>	오른쪽을 바라보는 전차(아래는 평지이다.)	==> 5


문자	동작
U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.

*/
import java.util.Scanner;

public class Solution_1873_상호의배틀필드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();					// 테케 수 입력
		for (int testcase = 1; testcase <= T; testcase++) {
			
			int H = sc.nextInt();
			int W = sc.nextInt();
			int [][]gameMap = new int[H][W];	// 비어있는 맵 생성
			int startX = 0, startY = 0;			// 전차 시작점 생성
			
			for(int i = 0; i < H; i++) {
				String mapInput = sc.next();
				for(int j= 0; j < W; j++) {
					char mapInputChar = mapInput.charAt(j);
					makeMap(gameMap, mapInputChar, i, j);	// 맵의 초기값 입력
					if(mapInputChar == '^' || mapInputChar == '<' ||
							mapInputChar == '>' || mapInputChar == 'v') {
						startX = i;
						startY = j;				// 전차 시작점 업데이트
					}
				}
			}
			
			int userInputLength = sc.nextInt();
			String userInput = sc.next();		// 사용자 입력
			for(int i = 0; i < userInputLength; i++) {
				int[] arr = changeMap(gameMap, userInput.charAt(i), startX, startY);	// 사용자 입력에 따른 맵 변화
				startX = arr[0];
				startY = arr[1];
			}
			System.out.print("#" + testcase + " ");
			printMap(gameMap);					// 결과 출력
			
		}
		
		sc.close();
		
	}
	
	// 사용자 입력에 따라, 맵의 상태를 변경한다.
	private static int[] changeMap(int[][] gameMap, char input, int x, int y) {
		int tempX = x;
		int tempY = y;		// 전차가 이동할 예상 지점
		int[] arr = new int[2];
		
		if(input=='U') {	// 위로 올라가는 경우
			tempX = tempX - 1; 
			if(tempX > -1) {	// 배열의 범위를 넘지 않는 경우
				if(gameMap[tempX][tempY]==0) {	// 가는 위치가 평지인 경우
					gameMap[tempX + 1][tempY] = 0;	// 기존 전차 위치 평지로 변환
				}
				else {
					tempX = tempX + 1;	// 원상복구
				}
			}
			else {			// 배열의 범위를 넘은 경우
				tempX = tempX + 1;	// 원상복구
			}
			gameMap[tempX][tempY] = 2;	// 현위치의 전차 방향을 위쪽으로 돌린다.
			
		}else if(input=='D') {	// 아래로 내려가는 경우
			tempX = tempX + 1; 
			if(tempX < gameMap.length) {	// 배열의 범위를 넘지 않는 경우
				if(gameMap[tempX][tempY]==0) {	// 가는 위치가 평지인 경우
					gameMap[tempX - 1][tempY] = 0;	// 기존 전차 위치 평지로 변환
				}
				else {
					tempX = tempX - 1;	// 원상복구
				}
			}
			else {			// 배열의 범위를 넘은 경우
				tempX = tempX - 1;	// 원상복구
			}
			gameMap[tempX][tempY] = 3;	// 현위치의 전차 방향을 아래쪽으로 돌린다.
			
		}else if(input=='L') {	// 왼쪽으로 가는 경우
			tempY = tempY - 1; 
			if(tempY > -1) {	// 배열의 범위를 넘지 않는 경우
				if(gameMap[tempX][tempY]==0) {	// 가는 위치가 평지인 경우
					gameMap[tempX][tempY + 1] = 0;	// 기존 전차 위치 평지로 변환
				}
				else {
					tempY = tempY + 1;	// 원상복구
				}
			}
			else {			// 배열의 범위를 넘은 경우
				tempY = tempY + 1;	// 원상복구
			}
			gameMap[tempX][tempY] = 4;	// 현위치의 전차 방향을 왼쪽으로 돌린다.
			
		}else if(input=='R') {	// 오른쪽으로 가는 경우
			tempY = tempY + 1; 
			if(tempY < gameMap[0].length) {	// 배열의 범위를 넘지 않는 경우
				if(gameMap[tempX][tempY]==0) {	// 가는 위치가 평지인 경우
					gameMap[tempX][tempY - 1] = 0;	// 기존 전차 위치 평지로 변환
				}
				else {
					tempY = tempY - 1;	// 원상복구
				}
			}
			else {			// 배열의 범위를 넘은 경우
				tempY = tempY - 1;	// 원상복구
			}
			gameMap[tempX][tempY] = 5;	// 현위치의 전차 방향을 오른쪽으로 돌린다.
		}else {		// 포탄을 쏘는 경우
			if(gameMap[x][y] == 2) {
				for(int i = x; i > -1; i--) {
					if(gameMap[i][y] == 1) {// 벽돌벽을 만난 경우
						gameMap[i][y] = 0;	// 평지로 바꾼다.
						break;
					} else if(gameMap[i][y] == -1) {	// 강철벽을 만난 경우
						break;
					}
				}
			}
			else if(gameMap[x][y] == 3) {
				for(int i = x; i < gameMap.length; i++) {
					if(gameMap[i][y] == 1) {// 벽돌벽을 만난 경우
						gameMap[i][y] = 0;	// 평지로 바꾼다.
						break;
					} else if(gameMap[i][y] == -1) { 	// 강철벽을 만난 경우
						break;
					}
				}
			}
			else if(gameMap[x][y] == 4) {
				for(int i = y; i > -1; i--) {
					if(gameMap[x][i] == 1) {// 벽돌벽을 만난 경우
						gameMap[x][i] = 0;	// 평지로 바꾼다.
						break;
					} else if(gameMap[x][i] == -1) { 	// 강철벽을 만난 경우
						break;
					}
				}
			}
			else if(gameMap[x][y] == 5) {
				for(int i = y; i < gameMap[0].length; i++) {
					if(gameMap[x][i] == 1) {// 벽돌벽을 만난 경우
						gameMap[x][i] = 0;	// 평지로 바꾼다.
						break;
					} else if(gameMap[x][i] == -1) {	// 강철벽을 만난 경우
						break;
					}
				}
			}
		}
		arr[0] = tempX;
		arr[1] = tempY;
		return arr;
	}
	
	// 최종 맵의 상태를 출력한다.
	private static void printMap(int[][]gameMap) {
		for(int i = 0; i < gameMap.length; i++) {
			for(int j= 0; j < gameMap[i].length; j++) {
				switch(gameMap[i][j]) {
				case 0:	// 평지:  0
					System.out.print(".");
					break;
				case 1:	// 벽돌:  1
					System.out.print("*");
					break;
				case -1:	// 강철: -1
					System.out.print("#");
					break;
				case -2:	// 물   : -2
					System.out.print("-");
					break;
				case 2:	// 위   :  2
					System.out.print("^");
					break;
				case 3:	// 아래:  3
					System.out.print("v");
					break;
				case 4:	// 왼   :  4
					System.out.print("<");
					break;
				case 5:	// 오른:  5
					System.out.print(">");
					break;
				}
			}
			System.out.println();
		}
	}
	
	// 스트링 연산 귀찮아서 만든 맵 생성 메서드
	private static void makeMap(int[][] gameMap, char input, int i, int j) {
		switch(input) {
		case '.':	// 평지:  0
			gameMap[i][j] = 0;
			break;
		case '*':	// 벽돌:  1
			gameMap[i][j] = 1;
			break;
		case '#':	// 강철: -1
			gameMap[i][j] = -1;
			break;
		case '-':	// 물   : -2
			gameMap[i][j] = -2;
			break;
		case '^':	// 위   :  2
			gameMap[i][j] = 2;
			break;
		case 'v':	// 아래:  3
			gameMap[i][j] = 3;
			break;
		case '<':	// 왼   :  4
			gameMap[i][j] = 4;
			break;
		case '>':	// 오른:  5
			gameMap[i][j] = 5;
			break;
		}
	}
}
