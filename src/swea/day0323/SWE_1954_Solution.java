package swea.day0323;

import java.util.Scanner;

public class SWE_1954_Solution {
	public static int [][]direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};	//우 하 좌 상
	public static int count = 0;
	
	public static void Snail(int[][] arr, int posX, int posY, int dirNum) {
		
		count++;
		arr[posX][posY] = count; // 대입하기
		
		if(count > arr.length * arr.length - 1)
			return;
		
		if(posX + direction[dirNum][0] < 0 || posX + direction[dirNum][0] > arr.length - 1
				|| posY + direction[dirNum][1] < 0 || posY + direction[dirNum][1] > arr.length - 1
				|| arr[posX + direction[dirNum][0]][posY + direction[dirNum][1]] != 0) {
			
			dirNum = (dirNum + 1) % 4;
			
		}
		
		posX = posX + direction[dirNum][0];
		posY = posY + direction[dirNum][1];
		Snail(arr, posX, posY, dirNum);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			count = 0;
			int arrSize = sc.nextInt();
			int[][] arr = new int[arrSize][arrSize];
			Snail(arr, 0, 0, 0);
			
			System.out.println("#" + (i + 1));
			for (int j = 0; j < arrSize; j++) {
				for (int j2 = 0; j2 < arr.length; j2++) {
					System.out.print(arr[j][j2] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
