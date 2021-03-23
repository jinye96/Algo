package swea.day0323;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//class Tree {
//	public int nodeNum;
//	public String nodeStatus;
//	public int leftLeaf;
//	public int rightLeaf;
//
//	public Tree(int nodeNum, String nodeStatus, int leftLeaf, int rightLeaf) {
//		super();
//		this.nodeNum = nodeNum;
//		this.nodeStatus = nodeStatus;
//		this.leftLeaf = leftLeaf;
//		this.rightLeaf = rightLeaf;
//	}
//
//	@Override
//	public String toString() {
//		return "Tree [nodeNum=" + nodeNum + ", nodeStatus=" + nodeStatus + ", leftLeaf=" + leftLeaf + ", rightLeaf="
//				+ rightLeaf + "]";
//	}
//}

public class Solution_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc < 11; tc++) {
			int N = Integer.parseInt(br.readLine());
			//Tree[] tr = new Tree[N];
			int can = 1;
			for (int i = 0; i < N; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				int left = 0, right = 0; // 정점이 없는 경우
				//int nodeNum = Integer.parseInt(stk.nextToken());
				String status = stk.nextToken();
				if (stk.hasMoreTokens()) {
					left = Integer.parseInt(stk.nextToken());
				}
				if (stk.hasMoreTokens()) {
					right = Integer.parseInt(stk.nextToken());
				}
				//tr[i] = new Tree(nodeNum, status, left, right);
				//System.out.println(tr[i]);
				if (left == 0 || right == 0) {
					if (status.charAt(0) - '0' < 0 || status.charAt(0) - '9' > 0) {
						can = 0;
					}
				} else if (left != 0 && right != 0) {
					if (status.charAt(0)!='+' && status.charAt(0)!='-' 
							&& status.charAt(0)!='*'&& status.charAt(0)!='/') {
						can = 0;
					}
				}
			}
			System.out.println("#" + tc + " " + can);
		}
		br.close();
	}
}
