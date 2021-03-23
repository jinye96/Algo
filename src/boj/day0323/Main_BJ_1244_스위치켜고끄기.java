package boj.day0323;
 
import java.util.Scanner;

public class Main_BJ_1244_스위치켜고끄기 {
	
	public static int changeSwitch(int sw) {	//스위치의 상태 변경
		return (sw == 1 ? 0 : 1);
	}
	
	public static void man(int[] sw, int num) {
		// 배수의 값을 가지고 있는 스위치 전환
		for(int i = num - 1; i < sw.length; i += num) {
			sw[i] = changeSwitch(sw[i]);
		}
	}
	public static void woman(int[] sw, int num) {
		
		int maxLen = (num < sw.length / 2) ? num - 1 : sw.length - num;
		int changeLen = 0;
		
		for(int i = 1; i < maxLen + 1; i++) {	
			//탐색 가능한 범위 내에서 스위치 대칭 여부 확인
			if(sw[num - 1 - i] == sw[num - 1 + i]) {
				changeLen++;
			}
			else
				break;
		}
		// 해당하는 범위의 스위치 전환
		sw[num - 1] = changeSwitch(sw[num - 1]);
		for(int i = 1; i < changeLen + 1; i++) {
			sw[num - 1 - i] = changeSwitch(sw[num - 1 - i]);
			sw[num - 1 + i] =changeSwitch(sw[num - 1 + i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int swNum = sc.nextInt();
		int[] sw = new int [swNum];
		
		for(int i = 0; i < swNum; i++) {
			sw[i] = sc.nextInt();
		}
		
		int pNum = sc.nextInt();
		for(int i = 0; i < pNum; i++) {
			int num = sc.nextInt();
			
			if(num == 1) 
				man(sw, sc.nextInt());
			else 
				woman(sw, sc.nextInt());
		}
		for(int i = 0; i < swNum; i++) {
			if(i !=0 && i % 20 == 0)
				System.out.println();
			System.out.print(sw[i] + " ");
		}
		
		sc.close();
	}
}