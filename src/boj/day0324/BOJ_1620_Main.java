package boj.day0324;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_1620_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<Integer, String> pocketmon = new HashMap<>();
		HashMap<String, Integer> pocketmon2 = new HashMap<>();
		for(int i = 1; i <= n; i++) {
			String input = sc.next();
			pocketmon.put(i,input);
			pocketmon2.put(input, i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i =0; i < m; i++) {
			String str = sc.next();
			//System.out.println(str);
			boolean flag = false;
			if(Character.isDigit(str.charAt(0))) {
				flag = true;
			}
			if(flag){
				sb.append(pocketmon.get(Integer.parseInt(str))+"\n");
			} else {
				sb.append(pocketmon2.get(str)+"\n");
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
