package boj.day0324;
import java.util.Scanner;

public class BOJ_2636_Main {
	
	static Scanner sc;
	static int[][] map;
	static boolean[][] visited;
	static int row, col, ans;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};	//상하좌우
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		row = sc.nextInt();
		col = sc.nextInt();
		ans = 0;
		
		makeMap(row, col);
		changeMap(0, 0);
		sc.close();
	}

	private static void changeMap(int x, int y) {
		visited = new boolean[row][col];
		if(countZero() > 0) {
			checkMap(0, 0); // 공기 접촉 영역을 -1로 변경
		}
		int temp = countOne();
		ans++;
		visited = new boolean[row][col];
		checkPixel(x, y);
		changePixel();
		
		if(countOne() > 0) {
			changeMap(x, y);
		}else {
			System.out.println(ans);
			System.out.println(temp);
		}
	}
	
	private static void changePixel() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j] == 2) {
					map[i][j] = -1;
				}
			}
		}
	}

	private static void checkPixel(int x, int y) {
		// 치즈 내부의 구멍이 공기와 접촉하는지 영역 확인
		visited[x][y] = true;
		if(map[x][y] == -1) {
			for(int d = 0; d < 4; d++) {
				int nx = dx[d] + x;
				int ny = dy[d] + y;
				if(nx > -1 && ny > -1 && nx < row && ny < col && !visited[nx][ny]) {
					if(map[nx][ny] == 1) {
						map[nx][ny] = 2;
					} else if(map[nx][ny] == -1) {
						checkPixel(nx, ny);
					}
				}
			}
		}
	}
	
	private static int countOne() {
		int count = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j] == 1) {
					count++;
				}
			}
		}
		return count;
	}

	private static int countZero() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j] == 0) {
					return 1;
				}
			}
		}
		return 0;
	}

	private static void checkMap(int x, int y) {
		// 치즈 내부의 구멍이 공기와 접촉하는지 영역 확인
		visited[x][y] = true;
		for(int d = 0; d < 4; d++) {
			int nx = dx[d] + x;
			int ny = dy[d] + y;
			if(nx > -1 && ny > -1 && nx < row && ny < col) {
				if(map[nx][ny] != 1 && !visited[nx][ny]) {
					map[nx][ny] = -1;
					checkMap(nx, ny);
				}
			}
		}
	}

	private static void makeMap(int row, int col) {
		map = new int[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < row; i++) {
			map[i][0] = -1;
			map[i][col-1] = -1;
		}
		for(int i = 0; i < col; i++) {
			map[0][i] = -1;
			map[row-1][i] = -1;
		}
	}
	
	private static void printMap() {
	for(int i= 0; i < row; i++) {
		for(int j = 0; j <col; j++) {
			System.out.print(map[i][j] + "\t");
		}
		System.out.println();
	}
}
//private static void printBooleanMap() {
//	for(int i= 0; i < row; i++) {
//		for(int j = 0; j <col; j++) {
//			System.out.print(visited[i][j] + "\t");
//		}
//		System.out.println();
//	}
//}

	
}
