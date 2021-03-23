package swea.day0323;

import java.util.Arrays;
import java.util.Scanner;

public class SWE_1983_Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String answer = "";
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();	// 학생 수
			int K = sc.nextInt(); 	// 학점을 봐야하는 학생의 인덱스
			
			double[] student = new double [N];	// 학생 점수 (중간, 기말, 과제)를 합산한 결과
			double checkScore = 0.0;
			for(int j = 0; j < N; j++) {
				double studentScore = (sc.nextDouble()*35 + sc.nextDouble()*45 + sc.nextDouble()*20)/100;
				student[j] = studentScore;
				if(j + 1 == K)
					checkScore = studentScore;
			}
			Arrays.sort(student);
			for (int j = 0; j < N; j++) {
				if(checkScore == student[j]) {
					answer = makeScore((double)j/(double)N);// 학점 판별하기
				}
			}
			
			System.out.println("#" + i + " " + answer);
		}
		sc.close();
	}
	
	private static String makeScore(double scoreRatio) {
		int scoreRatioInt = (int)(scoreRatio * 10);
		switch(scoreRatioInt){
			case 0:
				return "D0";
			case 1:
				return "C-";
			case 2:
				return "C0";
			case 3:
				return "C+";
			case 4:
				return "B-";
			case 5:
				return "B0";
			case 6:
				return "B+";
			case 7:
				return "A-";
			case 8:
				return "A0";
			default:
				return "A+";
		}
	}
}
