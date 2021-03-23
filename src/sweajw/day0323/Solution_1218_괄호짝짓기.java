package sweajw.day0323;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1218_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			Stack<Character> stack = new Stack<>();
			int strLength = sc.nextInt();
			String str = sc.next();
			char[] input = str.toCharArray();
			int answer = 1;
			char temp = '0';
			
			for (int i = 0; i < strLength; i++) {
				if(answer == 0)
					break;
				switch(input[i]) {
				case '(':
					stack.push('(');
					break;
				case '[':
					stack.push('[');
					break;
				case '{':
					stack.push('{');
					break;
				case '<':
					stack.push('<');
					break;
				case ')':
					if(!stack.isEmpty()) {
						temp = stack.pop();
					}
					else {
						answer = 0;
					}
					if(temp != '(') {
						answer = 0;
					}
					break;
				case ']':
					if(!stack.isEmpty()) {
						temp = stack.pop();
					}
					else {
						answer = 0;
					}if(temp != '[') {
						answer = 0;
					}
					break;
				case '}':
					if(!stack.isEmpty()) {
						temp = stack.pop();
					}
					else {
						answer = 0;
					}if(temp != '{') {
						answer = 0;
					}
					break;
				case '>':
					if(!stack.isEmpty()) {
						temp = stack.pop();
					}
					else {
						answer = 0;
					}if(temp != '<') {
						answer = 0;
					}
					break;
				}
			}
			if(!stack.isEmpty()) {
				answer = 0;
			}
			System.out.println("#" + testcase + " " + answer);
		}
		
		sc.close();
		
	}
}
