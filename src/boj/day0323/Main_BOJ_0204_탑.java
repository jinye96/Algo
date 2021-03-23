package boj.day0323;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//Main Idea
/*
유의미한 height로 이루어진 stack을 구성해 연산을 효율적으로. 
- 현재 타워보다, 왼쪽에 있는 타워가 작다면 stack에서 나가리.
- 그 외, stack에 차곡 차곡 쌓는다. 
 */

public class Main_BOJ_0204_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 막대기의 개수 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 입력된 막대기 높이 문자열을 " " 기준으로 Token화

		Stack<int[]> stack = new Stack<>(); // 쓸 데 없는 높이가 아닌 유의미한 높이 정보를 저장하는 stack
		//*************여기 고쳤습니다***********
		//for (int i = 0; i <= n; i++) {
		for (int i = 0; i < n; i++) {
			int height = Integer.parseInt(st.nextToken()); // 막대기 높이를 하나 하나 받아서 정수 화

			// 유의미한 높이 정보가 있는 동안
			while (!stack.isEmpty()) {
				if (stack.peek()[0] >= height) { // 유의미한 높이 정보를 갖는 stack의 첫 막대기 높이가 막대기의 높이보다 높다면
					System.out.print(stack.peek()[1] + " ");// 그 높이 정보를 출력한다.
					break;
				} // 유의미한 높이 정보를 갖는 stack의 첫 막대기 높이가 막대기의 높이보다 낮다면
				else {
					stack.pop(); // 그 높이 정보는 불필요한 값이므로 삭제한다.
				}
			}

			// 유의미한 높이 정보가 없다면: 부딪히는 애가 없다 ==> 0 출력
			if (stack.isEmpty()) {
				//*************여기 고쳤습니다***********
				//System.out.println("0 ");
				System.out.print("0 ");
			}

			//
			stack.push(new int[] { height, i + 1 }); //stack에 새로운 배열 객체를 생성하고 높이 정보와 인덱스를 저장한다. 
		}

	}// main
}// class