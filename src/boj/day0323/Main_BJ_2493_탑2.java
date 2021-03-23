package boj.day0323;
// 아무리 시도해도 시간 초과 에러가 나서 스택을 사용하는 방법에 대해 
// 방과후에 회재님께 질문해서 로직을 설명받은 뒤, 해당 로직을 이해하고 작성해본 코드입니다.
// 설명을 듣고 작성한 코드이기 때문에, 주석을 더 촘촘히 달았습니다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main_BJ_2493_탑2 {
	public static void main(String[] args) throws IOException {

		Stack<Integer> tower = new Stack<>();
		Stack<Integer> index = new Stack<>();	// 타워 높이와 인덱스 값을 저장하는 스택
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		int N = Integer.parseInt(br.readLine());	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 스택에 초기값 입력
		tower.push(Integer.parseInt(st.nextToken()));	// 첫 타워의 높이를 넣기
		index.push(1);					// 첫 타워의 인덱스로 스택 값 넣기
		System.out.print(0 + " ");		// 첫 타워는 무조건 신호를 받을 타워가 없음
		
		for(int i = 0; i < N - 1; i++) {
			int temp =Integer.parseInt(st.nextToken());
			while(!tower.isEmpty()) {		// 현재 타워의 신호를 받을 수도 있는 타워의 수
				if (temp < tower.peek()) {	// 앞에 타워가 신호를 수신한 경우
					System.out.print(index.peek() + " ");	// 타워의 인덱스 출력
					tower.push(temp);		// 더 적은 값으로 신호받을 수 있는 타워 높이 업데이트
					index.push(i + 2);		// 인덱스도 업데이트
					break;					// 업데이트가 완료되었으면 while문 종료하기
				}
				else {						// 앞의 타워가 신호를 수신하지 못한 경우
					tower.pop();			// 필요없는 타워가 된다(왜냐면 현재 타워가 더 높아서 뒤에 놈도 어차피 신호 못 받음)
					index.pop();			// 인덱스도 같이 갈아치워준다
				}
			}
			if(tower.isEmpty()) {			// 모든 타워가 신호를 수신하지 못한 경우
				tower.push(temp);			// 현재 타워의 높이가 현재로서는 가장 높은거니까 업데이트
				index.push(i + 2);			// 인덱스도 업데이트
				System.out.print(0 + " ");	// 나를 감당할 수 있는 타워의 높이는 없어.
			}
		}
	}
}
