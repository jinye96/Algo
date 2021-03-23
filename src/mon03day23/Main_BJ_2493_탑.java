package mon03day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_2493_탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList <Integer> tower = new ArrayList<>();
		ArrayList <Integer> answer = new ArrayList<>();
		
		// 입력 처리
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			tower.add(Integer.parseInt(st.nextToken()));
		}
		
		// 레이저 신호 수신 탐지
		for(int i = 0; i < N; i++) {
			for(int j = i - 1; j > -1; j--) {	// 확인하려는 탑의 위치보다 왼쪽에 있는 탑만 검사한다.
				if(tower.get(i) <= tower.get(j)) { // 탑이 신호를 수신할 수 있는 높이인 경우
					answer.add(j + 1);			// 신호를 수신한 탑의 위치를 저장	
					break;
				}
			}
			if(answer.size() < i + 1) {	// 탑이 신호를 수신 못해서 위치가 저장되지 않은 경우
				answer.add(0);
			}
		}
		
		// 출력하기
		for(int i = 0; i < answer.size() ; i++) {
			System.out.print(answer.get(i) + " ");
		}
		br.close();
	}
}
