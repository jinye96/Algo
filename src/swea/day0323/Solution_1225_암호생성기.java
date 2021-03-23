package swea.day0323;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			int testcase = sc.nextInt();
			
			Queue<Integer> q = new LinkedList<>();
			for(int j= 0; j < 8; j++) {
				q.offer(sc.nextInt());
			}
			int temp = 100;
			while(temp > 0) {
				for(int p = 1; p < 6; p++) {
					temp = (q.peek() - p) > 0 ? (q.peek() - p) : 0;
					q.poll();
					q.offer(temp);
					if(temp == 0) {
						break;
					}
				}
			}
			System.out.print("#" + testcase + " ");
			for(int j= 0; j < 8; j++) {
				System.out.print(q.peek() + " ");
				q.poll();
			}
			System.out.println();
		}
		sc.close();
	}
}
