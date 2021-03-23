package mon03day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1223_계산기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc < 11; tc++) {
			Stack<Integer> st = new Stack<>();
			int len = Integer.parseInt(br.readLine());
			
			String back = makePostFix(br.readLine());
			String[] stk = back.split("");
			for(int i = 0; i < len; i++) {
				String s = stk[i];
				switch(s) {
				case "+":
					st.push(st.pop() + st.pop());
					break;
				case "*":
					st.push(st.pop() * st.pop());
					break;
				default:
					//System.out.println(s);
					st.push(Integer.parseInt(s));
					break;
				}
			}
			System.out.println("#" + tc + " " + st.pop());
		}
		br.close();
	}
	
	private static String makePostFix(String str) {
		String[] stk = str.split("");
		ArrayList<String> func = new ArrayList<>();
		Stack<String> st = new Stack<>();
		int i = 0;
		while(i < stk.length) {
			String s = stk[i++];
			if(s.equals("*") || s.equals("+")) {
				// 연산자인 경우
				if(!st.isEmpty()) {
					if(st.peek().equals("*")) {	
						func.add(st.pop());
						st.push(s);
					}else {
						if(s.equals("*")) {
							func.add(stk[i++]);
							func.add(s);
						}
						else {
							func.add(s);
						}
					}
				}
				else {
					st.push(s);
				}
			}
			else {	// 숫자인 경우 그냥 넣기
				func.add(s);
			}
		}
		while(!st.isEmpty()) {
			func.add(st.pop());
		}
		StringBuilder sb = new StringBuilder();
		for (String ss : func) {
			sb.append(ss);
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}
}
