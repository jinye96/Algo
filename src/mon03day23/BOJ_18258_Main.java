package mon03day23;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_18258_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			StringTokenizer orderstk = new StringTokenizer(br.readLine());
			String order = orderstk.nextToken();
			if(order.equals("push")) {
				int push_int = Integer.parseInt(orderstk.nextToken());
				q.add(push_int);
				//System.out.println(push_int);
			}else {
				if(order.equals("front")) {
					if(!q.isEmpty())sb.append(q.getFirst()+"\n");
					else sb.append(-1+"\n");
				}
				else if(order.equals("back")) {
					if(!q.isEmpty())sb.append(q.getLast()+"\n");
					else sb.append(-1+"\n");
				}
				else if(order.equals("size")) {
					sb.append(q.size()+"\n");
				}
				else if(order.equals("empty")) {
					if(!q.isEmpty())sb.append(0+"\n");
					else sb.append(1+"\n");
				}
				else {
					if(!q.isEmpty()) {sb.append(q.getFirst()+"\n");
					q.pop();}
					else sb.append(-1+"\n");
				}
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
