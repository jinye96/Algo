package mon03day23;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3499_퍼펙트셔플 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr1 = new String[N / 2 + N % 2];
			String[] arr2 = new String[N / 2];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N / 2 + N % 2; i++) {
				arr1[i] = st.nextToken();
			}
			for (int i = 0; i < N / 2; i++) {
				arr2[i] = st.nextToken();
			}
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < N / 2; i++) {
				System.out.print(arr1[i] + " " + arr2[i] + " ");
			}
			if (N % 2 == 1) {
				System.out.print(arr1[N / 2 + N % 2 - 1]);
			}
			System.out.println();
		}
	}
}