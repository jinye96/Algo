package mon03day23;
import java.util.Scanner;

public class BOJ_16562_Main {
	static int n, m, k;
	static int[] money;
	static int[] parent;
	static int[] unionMoney;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		money = new int[n + 1];
		parent = new int[n + 1];
		unionMoney = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			money[i] = sc.nextInt();
			parent[i] = i;
		}
		
		for(int i= 0; i < m; i++) {
			union(sc.nextInt(), sc.nextInt());
		}
		
		for(int i = 1; i <= n; i++) {
			int find = find(i);
			if(unionMoney[find]!=0)
				unionMoney[find] = Math.min(money[i], unionMoney[find]);
			else 
				unionMoney[find] = money[i];
		}
		
		int total = 0;
		for(int i= 1; i <= n; i++) {
			total+= unionMoney[i];
		}
		if(total <= k) System.out.println(total);
		else System.out.println("Oh no");
		
		sc.close();
	}

	private static void union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);

		if (aroot != broot) {
			parent[aroot] = broot;
		}
	}

	private static int find(int i) {
		if (parent[i] == i)
			return i;
		else {
			return find(parent[i]);
		}
	}
}
