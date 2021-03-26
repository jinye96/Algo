package boj.day0326;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14502_Main {
	static int N, M, ans;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] mapInit, wall, map;
	static ArrayList<Pos> wallList;
	static ArrayList<Pos> virusList;
	static Queue<Pos> virus;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		mapInit = new int[N][M];
		wallList = new ArrayList<>();
		virusList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				mapInit[i][j] = sc.nextInt();
				if (mapInit[i][j] == 0) {
					Pos pos = new Pos(i, j);
					wallList.add(pos);
				} else if (mapInit[i][j] == 2) {
					Pos pos = new Pos(i, j);
					virusList.add(pos);
				}
			}
		}
		wall = new int[3][2];
		ans = Integer.MIN_VALUE;
		combination(0, 0);
		System.out.println(ans);
		sc.close();
	}

	private static void combination(int cnt, int start) {
		if (cnt == 3) {
			initMap();
			spreadVirus(0, 0);
			return;
		}
		for (int i = start; i < wallList.size(); i++) {
			wall[cnt][0] = wallList.get(i).x;
			wall[cnt][1] = wallList.get(i).y;
			combination(cnt + 1, i + 1);
		}
	}

	private static void initMap() {
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = mapInit[i][j];
			}
		}
		for(int i = 0; i < 3; i++) {
			map[wall[i][0]][wall[i][1]] = 1;
		}
		
		virus = new LinkedList<>();
		for(int i = 0;i < virusList.size(); i++) {
			virus.offer(virusList.get(i));
		}
	}

	private static void spreadVirus(int x, int y) {
		while(!virus.isEmpty()) {
			Pos p = virus.poll();
			for(int d = 0; d < 4; d++) {
				if(p.x + dx[d] > -1 && p.y + dy[d] > -1 && 
						p.x + dx[d] < N && p.y + dy[d] < M) {
					if(map[p.x + dx[d]][p.y + dy[d]] == 0) {
						Pos newVirus = new Pos(p.x + dx[d], p.y + dy[d]);
						map[newVirus.x][newVirus.y] = 2;
						virus.offer(newVirus);
					}
				}
			}
		}
		countSafeZone();
	}

	private static void countSafeZone() {
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					temp++;
				}
			}
		}
		ans = Math.max(temp, ans);
	}
}

class Pos {
	int x;
	int y;

	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pos [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append("]");
		return builder.toString();
	}

}
