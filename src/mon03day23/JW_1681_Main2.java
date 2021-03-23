package mon03day23;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JW_1681_Main2 {
	
	private static class Node implements Comparable<Node>{
		int vertex;
		int totalDistance;
		
		public Node(int vertex, int totalDistance) {
			this.vertex = vertex;
			this.totalDistance = totalDistance;
		}

		@Override
		public int compareTo(Node o) {
			return this.totalDistance-o.totalDistance;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", distance=" + totalDistance + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); //정점 갯수
		int start = 0; //시작점 인덱스
		int end =  V-1; //도착점 인덱스
		final int INFINITY = Integer.MAX_VALUE;
		
		int[][] matrix = new int[V][V];
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		
		for(int i=0; i<V; ++i){
			st = new StringTokenizer(in.readLine().trim());
			for(int j=0; j<V; ++j){
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.offer(new Node(start,distance[start]));
		
		Node current = null;
        while(!queue.isEmpty()){
			
			//a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
        	current = queue.poll();
        	if(visited[current.vertex])continue;
        	
			visited[current.vertex] = true; // 선택 정점 방문 처리
			if(current.vertex == end) break; // 선택 정점이 도착정점이면 탈출.
			
			//b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(int c=0; c<V; ++c){
				if(!visited[c] && matrix[current.vertex][c] != 0
						&&  distance[c] >current.totalDistance+matrix[current.vertex][c]){
					distance[c] = current.totalDistance+matrix[current.vertex][c];
					queue.offer(new Node(c,distance[c]));
					System.out.println(c);					
				}
			}
		}
		System.out.println(distance[end]);
		
	}
}
