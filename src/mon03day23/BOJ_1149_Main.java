package mon03day23; 
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1149_Main {
	public static void main(String[] args) {
		// 각각 빨강을 골랐을 때의 비용이랑 초록을 골랐을 떄의 비용이랑 파랑을 골랐을 때의 비용을 계산할 수 있다.
		// 해당 색깔이 유지될 경우와 아닌 경우 두 가지로 나누어서 dp를 진행하면 될 것 같은데 일단 해보자~
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[3];
		int[] temp = new int[3];

		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();

		for (int i = 1; i < n; i++) {
			int[] cal = new int[3];
			temp[0] = sc.nextInt();
			temp[1] = sc.nextInt();
			temp[2] = sc.nextInt();
			
			cal[0] = temp[0] + Math.min(arr[1], arr[2]);
			cal[1] = temp[1] + Math.min(arr[0], arr[2]);
			cal[2] = temp[2] + Math.min(arr[0], arr[1]);
			
			arr[0] = cal[0];
			arr[1] = cal[1];
			arr[2] = cal[2];
		}
		
		Arrays.sort(arr);
		System.out.println(arr[0]);
		
		sc.close();
	}
}
